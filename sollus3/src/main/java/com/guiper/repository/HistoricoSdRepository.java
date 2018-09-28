package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoSd;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoSdRepository extends CrudRepository<HistoricoSd, Integer>{
    
    List<HistoricoSd> findByDataHora(Date dataHora);
    
}
