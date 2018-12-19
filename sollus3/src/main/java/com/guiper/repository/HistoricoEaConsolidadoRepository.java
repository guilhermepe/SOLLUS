package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoEaConsolidado;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoEaConsolidadoRepository extends CrudRepository<HistoricoEaConsolidado, Integer>{
    
    List<HistoricoEaConsolidado> findByDataHora(Date dataHora);
    List<HistoricoEaConsolidado> findByIdPorta(Long idPorta);
    
}
