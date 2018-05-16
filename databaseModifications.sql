/*Adaptações realizadas no banco de dados

Init MYSQL inside docker
docker run --name mysql_sollos -e MYSQL_ROOT_PASSWORD='passwd' -e MYSQL_DATABASE='sollos' -e MYSQL_USER='sollos' -e MYSQL_PASSWORD='sollos'  -d -p 3306:3306 mysql:tag --event-scheduler=ON --skip-ssl

Check
docker volume ls    -   docker volume prune

Import database with CLI tool
mysql -u root --host=127.0.0.1 --port=3306 --password=passwd --force sollos<dumpfile.sql

Totalizações

Tarefas relacionadas:
✓ Criação de tabela com controle de totalização
✓ Movimentação dos dados das tabelas de leitura para a tabela consolidada.
✓ Criação das tabelas totalizadas.
✓ Adicionar coluna na tabela de portas para sinalizar quais devem ser totalizadas.
✓ Criação da tabela de log de inconsistência de totalização.
✓ Criação das rotinas PL/Sql para totalização dos dados (Diário, e mensal).
✓ Criação dos triggers nas tabelas de entrada dos dados pelo servidor de coleta original
✓ Crição do evento que irá acionar a rotina de totalização.

Implantação das rotinas de totalização
Ativação do Event Scheduler do MySQL

Ativação do Event Scheduler daemon para realizar as totalizações sem depender de agendadores de tarefas do sistema operacional subjacente.

Referência mysql documentation
https://dev.mysql.com/doc/refman/5.7/en/events-configuration.html

*/

SET GLOBAL event_scheduler = ON;
SET @@global.event_scheduler = ON;
SET GLOBAL event_scheduler = 1;
SET @@global.event_scheduler = 1;
show processlist;

/*Deve ser alterado o arquivo my.cnf para persistir a ativação do event scheduler*/

Criação das Novas Tabelas
CREATE TABLE `log_table` (
  `idlog` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(256) DEFAULT NULL,
  `timestamp` varchar(45) NOT NULL DEFAULT 'now',
  PRIMARY KEY (`idlog`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `historico_ea_consolidado` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_Porta` bigint(20) NOT NULL,
  `valor_porta` float NOT NULL DEFAULT '0',
  `alarme` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `data_hora` datetime NOT NULL,
  `totalizado_diario` boolean NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`id`,`id_Porta`)  
) ENGINE=InnoDb AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `historico_ea_diario` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_Porta` bigint(20) NOT NULL,
  `nome_Porta` char(255),
  `id_Equipamento` bigint(20) NOT NULL,
  `nome_Equipamento` char(255),
  `id_Conta` bigint(20) NOT NULL,
  `nome_Conta` char(50),
  `valor_porta_inicial` float NOT NULL DEFAULT '0',
  `valor_porta_final` float NOT NULL DEFAULT '0',
  `valor_porta_delta` float NOT NULL DEFAULT '0',  
  `dia_Registro` date NOT NULL,
  `totalizado_mensal` boolean NOT NULL DEFAULT FALSE,
  `totalizacao` datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`,`id_Porta`),
  KEY `Ix_hdiario` (`id_Porta`,`dia_Registro`,`id_Equipamento`) USING BTREE
) ENGINE=InnoDb AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `historico_ea_mensal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `id_Porta` bigint(20) NOT NULL,
  `nome_Porta` char(255),
  `id_Equipamento` bigint(20) NOT NULL,
  `nome_Equipamento` char(255),
  `id_Conta` bigint(20) NOT NULL,  
  `nome_Conta` char(50),
  `valor_porta_inicial` float NOT NULL DEFAULT '0',
  `valor_porta_final` float NOT NULL DEFAULT '0',
  `valor_porta_delta` float NOT NULL DEFAULT '0',  
  `dia_Registro` date NOT NULL,
  `totalizacao` datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`,`id_Porta`),
  KEY `Ix_hmensal` (`id_Porta`,`dia_Registro`,`id_Equipamento`)
) ENGINE=InnoDb AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/* Popular tabela consolidada */
insert into sollos.historico_ea_consolidado(id_Porta,valor_porta,alarme,data_hora)
select idPorta,valor_porta,alarme,data_hora from historicorecente_ea;

insert into sollos.historico_ea_consolidado(id_Porta,valor_porta,alarme,data_hora)
select idPorta,valor_porta,alarme,data_hora from historico_ea;

/* Alterar a tabela portas 
Inclusão do flag de totalização. */

ALTER TABLE `sollos`.`portas`
ADD COLUMN `totalizar` TINYINT NOT NULL DEFAULT '0' AFTER `categoria`;
Selecionar apenas a variável “medidor mecânico” para a totalização
UPDATE portas set totalizar=1 where nome = 'Mecânico' AND idPortas > 0;
SELECT * from portas where totalizar = 1;

/* Código da rotina de totalização */
CREATE DEFINER=`root`@`%` PROCEDURE `totalizacao`()
BEGIN

/*Variáveis*/
DECLARE done_l1 BOOLEAN;
DECLARE done BOOLEAN;
DECLARE v_porta INT(20) DEFAULT 0;
DECLARE v_id_Porta int(20);
DECLARE v_nome_Porta char(255);
DECLARE v_id_Equipamento int(20);
DECLARE v_nome_Equipamento char(255);
DECLARE v_id_Conta int(20);
DECLARE v_nome_Conta char(255);
DECLARE v_valor_porta_inicial float;
DECLARE v_valor_porta_final float;
DECLARE v_valor_porta_delta float;
DECLARE v_dia_Registro date;
DECLARE v_id_mensal_update INT(20);

/*cursores*/
/*Seleção das portas a serem totalizadas com registros pendentes*/
DECLARE c_portas CURSOR FOR SELECT distinct id_Porta FROM historico_ea_consolidado WHERE
totalizado_diario=0 AND id_Porta
IN( SELECT idPortas FROM portas WHERE totalizar=1 );
/* workaround cursor para tabela temporária */
DECLARE c_mensal CURSOR FOR SELECT * FROM t_mensal_tmp;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
/*Selecao de totalizações para a tabela mensal*/

OPEN c_portas;

l_loop1: LOOP
FETCH c_portas INTO v_porta;
    IF done THEN
        LEAVE l_loop1;
    END IF;
    
    /* LOG */
    INSERT INTO log_table VALUES(null,CONCAT('Inicio da totalizacao ',v_porta),now());    
    
    /* Selecao e insercao na totalização diária
    serão totalizados os registros até D-1*/
    INSERT INTO historico_ea_diario (id_Porta,nome_Porta,
    id_Equipamento,nome_Equipamento,id_Conta,nome_Conta,valor_porta_inicial,
    valor_porta_final,valor_porta_delta,dia_Registro) select
    id_Porta, portas.nome AS nome_Porta,
    portas.Equipamento_id AS id_Equipamento,
    equipamento.nome AS nome_Equipamento, contas.id AS id_Conta,
    contas.nome AS nome_Conta,
    min(valor_porta) AS valor_porta_inicial,
    max(valor_porta) AS valor_porta_final,
    (max(valor_porta)-min(valor_porta)) AS valor_porta_delta,
    date_format(historico_ea_consolidado.data_hora,'%Y-%m-%d') AS dia_Registro
    from historico_ea_consolidado
    left join portas on id_Porta=idPortas
    left join equipamento on portas.Equipamento_id=equipamento.id
    left join contas on equipamento.contas_id=contas.id
    where id_Porta=v_porta AND totalizado_diario=0 AND
    historico_ea_consolidado.data_hora < (now() + INTERVAL -1 DAY)    
    group by date_format(data_hora,'%Y-%m-%d');
    
     /* Update da totalização diária na tabela consolidada até D-1*/  
    
    
UPDATE historico_ea_consolidado
SET
    totalizado_diario = 1
WHERE
    id_Porta = v_porta
        AND totalizado_diario = 0
        AND data_hora < (NOW() + INTERVAL - 1 DAY)
        AND id > 0;
     
     /* Selecao da a totalização mensal
    serão totalizados os registros até D-1*/
        
    DROP TEMPORARY TABLE IF EXISTS t_mensal_tmp;    
    create temporary table t_mensal_tmp engine=memory
    select
    id_Porta, portas.nome AS nome_Porta,
    portas.Equipamento_id AS id_Equipamento,
    equipamento.nome AS nome_Equipamento, contas.id AS id_Conta,
    contas.nome AS nome_Conta,
    min(valor_porta_inicial) AS valor_porta_inicial,
    max(valor_porta_final) AS valor_porta_final,
    (max(valor_porta_final)-min(valor_porta_inicial)) AS valor_porta_delta,
    last_day(dia_Registro) AS dia_Registro
    from historico_ea_diario
    left join portas on id_Porta=idPortas
    left join equipamento on portas.Equipamento_id=equipamento.id
    left join contas on equipamento.contas_id=contas.id
    where historico_ea_diario.id_Porta=v_porta
    AND dia_Registro < (now() + INTERVAL -1 DAY)
    group by last_day(dia_Registro);

-- update dos registros já existentes em historico_ea_mensal
    OPEN c_mensal;
    
    l_loop2: LOOP   
    
    FETCH c_mensal INTO v_id_Porta,v_nome_Porta,v_id_Equipamento,
    v_nome_Equipamento,v_id_Conta,v_nome_Conta,v_valor_porta_inicial,
    v_valor_porta_final,v_valor_porta_delta,v_dia_Registro;
        IF done THEN
            LEAVE l_loop2;
        END IF;
    
        IF EXISTS (SELECT id FROM historico_ea_mensal where
            dia_Registro=v_dia_Registro AND id_Porta=v_id_Porta) THEN
            
                UPDATE historico_ea_mensal SET valor_porta_final=v_valor_porta_final,
                valor_porta_delta=valor_porta_delta+v_valor_porta_delta,totalizacao=NOW()
                WHERE dia_registro=v_dia_registro AND id_porta=v_id_porta
                AND historico_ea_mensal.valor_porta_final < v_valor_porta_final
                AND id > 0;
        ELSE
                
                INSERT INTO historico_ea_mensal VALUES(null,
                v_id_Porta,v_nome_Porta,v_id_Equipamento,
                v_nome_Equipamento,v_id_Conta,v_nome_Conta,
                v_valor_porta_inicial,v_valor_porta_final,
                v_valor_porta_delta,v_dia_Registro,now());
        END IF;
    
    END LOOP l_loop2;
    CLOSE c_mensal;
    DROP TEMPORARY TABLE t_mensal_tmp;
    /*Reset da var de controle para evitar cancelamento do loop_l1 */
    SET done = FALSE;

/* Update da totalização mensal na tabela diária até D-1*/

UPDATE historico_ea_diario
SET
    totalizado_mensal = 1
WHERE
    id_Porta = v_porta
        AND totalizado_mensal = 0        
        AND id > 0;
     
     /* LOG */
    INSERT INTO log_table VALUES(null,CONCAT('Fim da totalização ',v_porta),now());
    
END LOOP l_loop1;
CLOSE c_portas;
END

/* Trigger de transferência da tabela original para a consolidada */
create trigger t_insere_consolidado
AFTER INSERT on historicorecente_ea
for each row
insert into historico_ea_consolidado
 select null,idPorta,valor_porta,alarme,data_hora,0
 from historicorecente_ea where id = NEW.id;
 
/*Evento de disparo da totalização*/
CREATE EVENT e_dispara_totalizacao
ON SCHEDULE EVERY 12 HOUR
STARTS current_timestamp
DO CALL TOTALIZACAO;

/*Inserção de dados DUMMY*/
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514865,0,'2017-12-28 08:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514866,0,'2017-12-28 09:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514867,0,'2017-12-28 10:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514868,0,'2017-12-28 11:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514869,0,'2017-12-28 12:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514870,0,'2017-12-28 13:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514871,0,'2017-12-28 14:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514872,0,'2017-12-28 15:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514873,0,'2017-12-28 16:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514874,0,'2017-12-28 17:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514875,0,'2017-12-28 18:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514876,0,'2017-12-28 19:00:00');
INSERT INTO `sollos`.`historicorecente_ea` VALUES (null,16345,514877,0,'2017-12-28 20:00:00');

