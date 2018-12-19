package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoEaMensal;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoEaMensalRepository extends CrudRepository<HistoricoEaMensal, Integer>{
    
    List<HistoricoEaMensal> findByDiaRegistro(Date diaRegistro);
    List<HistoricoEaMensal> findByNomeEquipamento(String nomeEquipamento);
    List<HistoricoEaMensal> findByIdPorta(Long idPorta);
    
}
