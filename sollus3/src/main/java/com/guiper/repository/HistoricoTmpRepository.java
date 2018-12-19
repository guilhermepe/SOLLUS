package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoTmp;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoTmpRepository extends CrudRepository<HistoricoTmp, Integer>{
    
    List<HistoricoTmp> findByDataHora(Date dataHora);
    
}
