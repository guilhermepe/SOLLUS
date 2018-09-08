package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long contasId;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String nome;
    private long ip;
    private int habilitado;
    @Column(name = "idlocal")
    private long idLocal;
    @Column(name = "idservidor")
    private long idServidor;
    @Column(name = "emailalarmeeq")
    private String emailAlarmeEq;
    @Column(name = "tempoalarmeeq")
    private int tempoAlarmeEq;
    private String login;
    private String senha;
    private float latitude;
    private float longitude;
    private int excluido;
    private String numeroserie;
    @Column(name = "alarmesms")
    private int alarmeSms;
    @Column(name = "alarmehabilitado")
    private int alarmeHabilitado;
    @Column(name = "datahoraultimaleitura")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraUltimaLeitura;
    @Column(name = "fotoequipamento")
    private String fotoEquipamento;
    @Column(name = "idmodelo")
    private int idModelo;
    @Column(name = "idprotocolo")
    private int idProtocolo;
    @Column(name = "portatcp")
    private int portaTcp;
    @Column(name = "idstatus")
    private int idStatus;
    @Column(name = "idtipoconexao")
    private int idTipoConexao;
    @Column(name = "timeoutLeitura")
    private int timeOutLeitura;
    @Column(name = "timeoutConexao")
    private int timeOutConexao;
    @Column(name = "intervaloleitura")
    private int intervaloLeitura;
    @Column(name = "numRetentativas")
    private int numRetentivas;
    @Column(name = "dataHora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "dataInstalacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataInstalacao;
    @Column(name = "dataCriacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "enderecoagente")
    private String enderecoAgente;
    private String descricao;
    @Column(name = "keepalive")
    private int keepAlive;
    @Column(name = "apagarlogs")
    private int apagarLogs;
    @Column(name = "hexfirmware")
    private String hexFirmware;
    @Column(name = "versaofirmware")
    private String versaoFirmware;
    @Column(name = "versaohardware")
    private String versaoHardware;

    @Override
    public String toString() {
        return "Equipamento[" + "id=" + id + ", contasId=" + contasId + ", nome=" + nome + ", ip=" + ip + ", habilitado=" + habilitado + ", idLocal=" + idLocal + ", idServidor=" + idServidor + ", emailAlarmeEq=" + emailAlarmeEq + ", tempoAlarmeEq=" + tempoAlarmeEq + ", login=" + login + ", senha=" + senha + ", latitude=" + latitude + ", longitude=" + longitude + ", excluido=" + excluido + ", numeroserie=" + numeroserie + ", alarmeSms=" + alarmeSms + ", alarmeHabilitado=" + alarmeHabilitado + ", dataHoraUltimaLeitura=" + dataHoraUltimaLeitura + ", fotoEquipamento=" + fotoEquipamento + ", idModelo=" + idModelo + ", idProtocolo=" + idProtocolo + ", portaTcp=" + portaTcp + ", idStatus=" + idStatus + ", idTipoConexao=" + idTipoConexao + ", timeOutLeitura=" + timeOutLeitura + ", timeOutConexao=" + timeOutConexao + ", intervaloLeitura=" + intervaloLeitura + ", numRetentivas=" + numRetentivas + ", dataHora=" + dataHora + ", dataInstalacao=" + dataInstalacao + ", dataCriacao=" + dataCriacao + ", enderecoAgente=" + enderecoAgente + ", descricao=" + descricao + ", keepAlive=" + keepAlive + ", apagarLogs=" + apagarLogs + ", hexFirmware=" + hexFirmware + ", versaoFirmware=" + versaoFirmware + ", versaoHardware=" + versaoHardware + ']';
    }
    
    //Constructors

    public Equipamento() {
    }

    public Equipamento(String nome) {
        this.nome = nome;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContasId() {
        return contasId;
    }

    public void setContasId(long contasId) {
        this.contasId = contasId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIp() {
        return ip;
    }

    public void setIp(long ip) {
        this.ip = ip;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(long idLocal) {
        this.idLocal = idLocal;
    }

    public long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(long idServidor) {
        this.idServidor = idServidor;
    }

    public String getEmailAlarmeEq() {
        return emailAlarmeEq;
    }

    public void setEmailAlarmeEq(String emailAlarmeEq) {
        this.emailAlarmeEq = emailAlarmeEq;
    }

    public int getTempoAlarmeEq() {
        return tempoAlarmeEq;
    }

    public void setTempoAlarmeEq(int tempoAlarmeEq) {
        this.tempoAlarmeEq = tempoAlarmeEq;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getExcluido() {
        return excluido;
    }

    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public int getAlarmeSms() {
        return alarmeSms;
    }

    public void setAlarmeSms(int alarmeSms) {
        this.alarmeSms = alarmeSms;
    }

    public int getAlarmeHabilitado() {
        return alarmeHabilitado;
    }

    public void setAlarmeHabilitado(int alarmeHabilitado) {
        this.alarmeHabilitado = alarmeHabilitado;
    }

    public Date getDataHoraUltimaLeitura() {
        return dataHoraUltimaLeitura;
    }

    public void setDataHoraUltimaLeitura(Date dataHoraUltimaLeitura) {
        this.dataHoraUltimaLeitura = dataHoraUltimaLeitura;
    }

    public String getFotoEquipamento() {
        return fotoEquipamento;
    }

    public void setFotoEquipamento(String fotoEquipamento) {
        this.fotoEquipamento = fotoEquipamento;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdProtocolo() {
        return idProtocolo;
    }

    public void setIdProtocolo(int idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    public int getPortaTcp() {
        return portaTcp;
    }

    public void setPortaTcp(int portaTcp) {
        this.portaTcp = portaTcp;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdTipoConexao() {
        return idTipoConexao;
    }

    public void setIdTipoConexao(int idTipoConexao) {
        this.idTipoConexao = idTipoConexao;
    }

    public int getTimeOutLeitura() {
        return timeOutLeitura;
    }

    public void setTimeOutLeitura(int timeOutLeitura) {
        this.timeOutLeitura = timeOutLeitura;
    }

    public int getTimeOutConexao() {
        return timeOutConexao;
    }

    public void setTimeOutConexao(int timeOutConexao) {
        this.timeOutConexao = timeOutConexao;
    }

    public int getIntervaloLeitura() {
        return intervaloLeitura;
    }

    public void setIntervaloLeitura(int intervaloLeitura) {
        this.intervaloLeitura = intervaloLeitura;
    }

    public int getNumRetentivas() {
        return numRetentivas;
    }

    public void setNumRetentivas(int numRetentivas) {
        this.numRetentivas = numRetentivas;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getEnderecoAgente() {
        return enderecoAgente;
    }

    public void setEnderecoAgente(String enderecoAgente) {
        this.enderecoAgente = enderecoAgente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getApagarLogs() {
        return apagarLogs;
    }

    public void setApagarLogs(int apagarLogs) {
        this.apagarLogs = apagarLogs;
    }

    public String getHexFirmware() {
        return hexFirmware;
    }

    public void setHexFirmware(String hexFirmware) {
        this.hexFirmware = hexFirmware;
    }

    public String getVersaoFirmware() {
        return versaoFirmware;
    }

    public void setVersaoFirmware(String versaoFirmware) {
        this.versaoFirmware = versaoFirmware;
    }

    public String getVersaoHardware() {
        return versaoHardware;
    }

    public void setVersaoHardware(String versaoHardware) {
        this.versaoHardware = versaoHardware;
    }
    
    

}

/**
 * CREATE TABLE `equipamento` ( `id` bigint(20) NOT NULL AUTO_INCREMENT,
 * `contas_id` bigint(20) NOT NULL, `nome` char(50) NOT NULL DEFAULT 'Sem Nome',
 * `ip` char(100) DEFAULT NULL, `habilitado` tinyint(3) unsigned NOT NULL
 * DEFAULT '1', `idLocal` bigint(20) DEFAULT NULL, `idServidor` tinyint(3)
 * unsigned DEFAULT '1', `emailAlarmeEq` tinyint(3) unsigned NOT NULL DEFAULT
 * '1', `tempoAlarmeEq` int(10) unsigned NOT NULL DEFAULT '3600000', `login`
 * char(35) DEFAULT NULL, `senha` char(15) DEFAULT NULL, `latitude` float NOT
 * NULL DEFAULT '0', `longitude` float NOT NULL DEFAULT '0', `excluido`
 * tinyint(3) unsigned NOT NULL DEFAULT '0', `numeroSerie` char(35) DEFAULT
 * NULL, `alarmeSms` tinyint(3) unsigned NOT NULL DEFAULT '0',
 * `alarmeHabilitado` tinyint(3) unsigned NOT NULL DEFAULT '1',
 * `dataHoraUltimaLeitura` datetime DEFAULT NULL, `fotoEquipamento` char(200)
 * DEFAULT NULL, `idModelo` smallint(5) unsigned DEFAULT NULL, `idProtocolo`
 * smallint(5) unsigned DEFAULT NULL, `portaTcp` smallint(5) unsigned DEFAULT
 * NULL, `idStatus` tinyint(3) unsigned DEFAULT '3', `idTipoConexao` tinyint(3)
 * unsigned DEFAULT NULL, `timeOut_leitura` int(10) unsigned NOT NULL DEFAULT
 * '10000', `timeOut_conexao` int(10) unsigned DEFAULT '5000',
 * `intervaloLeitura` int(10) unsigned NOT NULL DEFAULT '15000',
 * `num_retentativas` tinyint(3) unsigned NOT NULL DEFAULT '2', `data_hora`
 * datetime DEFAULT NULL, `data_instalacao` datetime DEFAULT NULL,
 * `data_criacao` datetime DEFAULT NULL, `enderecoAgente` varchar(15) DEFAULT
 * NULL, `descricao` char(255) DEFAULT 'Nenhum Comentario', `keepAlive`
 * tinyint(3) unsigned NOT NULL DEFAULT '1', `apagarLogs` tinyint(3) unsigned
 * DEFAULT '0', `hexFirmware` char(255) DEFAULT NULL, `versaoFirmware` char(15)
 * DEFAULT NULL, `versaoHardware` char(15) DEFAULT NULL, PRIMARY KEY (`id`), KEY
 * `Ix_contas` (`contas_id`) USING BTREE, KEY `Ix_IpPortaTcp` (`ip`,`portaTcp`)
 * USING BTREE, KEY `Ix_habilitado` (`habilitado`), KEY `Ix_modelo` (`idModelo`)
 * USING BTREE, KEY `Ix_protocolo` (`idProtocolo`) USING BTREE, KEY
 * `Ix_portaTcp` (`portaTcp`) USING BTREE, KEY `Ix_statusEq` (`idStatus`) USING
 * BTREE, KEY `Ix_tipoCon` (`idTipoConexao`) USING BTREE, KEY `Ix_local`
 * (`idLocal`) USING BTREE, KEY `Ix_servidor` (`idServidor`) USING BTREE, KEY
 * `FK_equip_conta` (`contas_id`), KEY `FK_equip_modelo` (`idModelo`),
 */
