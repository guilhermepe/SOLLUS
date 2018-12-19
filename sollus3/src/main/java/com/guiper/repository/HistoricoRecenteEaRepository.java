package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoRecenteEa;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoRecenteEaRepository extends CrudRepository<HistoricoRecenteEa, Integer>{
    
    List<HistoricoRecenteEa> findByDataHora(Date dataHora);
    List<HistoricoRecenteEa> findByIdPorta(Long idPorta);
    
}
