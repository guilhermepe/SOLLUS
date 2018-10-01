package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoEa;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoEaRepository extends CrudRepository<HistoricoEa, Integer>{
    
    List<HistoricoEa> findByDataHora(Date dataHora);
    List<HistoricoEa> findByIdPorta(Long idPorta);
    
}
