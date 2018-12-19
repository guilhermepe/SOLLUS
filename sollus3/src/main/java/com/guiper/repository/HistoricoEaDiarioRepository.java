package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoEaDiario;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoEaDiarioRepository extends CrudRepository<HistoricoEaDiario, Integer>{
    
    List<HistoricoEaDiario> findByDiaRegistro(Date diaRegistro);
    List<HistoricoEaDiario> findByNomeEquipamento(String nomeEquipamento);
    List<HistoricoEaDiario> findByIdPorta(Long idPorta);
    List<HistoricoEaDiario> findByIdEquipamento(Long idEquipamento);
    
}
