package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.CriticidadeAlarme;

/**
 *
 * @author guiper
 */
public interface CriticidadeAlarmeRepository extends CrudRepository<CriticidadeAlarme, Integer>{
    
    List<CriticidadeAlarme> findBySeveridade(String severidade);
    
}
