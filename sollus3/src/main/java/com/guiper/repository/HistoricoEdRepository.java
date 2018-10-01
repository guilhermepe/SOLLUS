package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoEd;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoEdRepository extends CrudRepository<HistoricoEd, Integer>{
    
    List<HistoricoEd> findByDataHora(Date dataHora);
    List<HistoricoEd> findByIdPorta(Long idPorta);
    
}
