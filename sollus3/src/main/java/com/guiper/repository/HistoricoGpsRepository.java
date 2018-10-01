package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoGps;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoGpsRepository extends CrudRepository<HistoricoGps, Integer>{
    
    List<HistoricoGps> findByDataHora(Date dataHora);
    List<HistoricoGps> findByIdEquipamento(Long idPorta);
    
}
