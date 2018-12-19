package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoRecenteSd;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoRecenteSdRepository extends CrudRepository<HistoricoRecenteSd, Integer>{
    
    List<HistoricoRecenteSd> findByDataHora(Date dataHora);
    List<HistoricoRecenteSd> findByIdPorta(Long idPorta);
    
}
