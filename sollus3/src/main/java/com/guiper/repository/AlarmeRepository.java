package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Alarme;

/**
 *
 * @author guiper
 */
public interface AlarmeRepository extends CrudRepository<Alarme, Integer>{
    
    List<Alarme> findByIdPorta(Long idPorta);
    List<Alarme> findByLoginRecAlarme(String loginRecAlarme);
    List<Alarme> findByLoginRecNormal(String loginRecNormal);
    
}
