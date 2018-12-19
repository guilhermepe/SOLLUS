package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.TipoAlarme;

/**
 *
 * @author guiper
 */
public interface TipoAlarmeRepository extends CrudRepository<TipoAlarme, Integer>{
    
    List<TipoAlarme> findByTipoAlarmeDescricao(String tipoAlarmeDescricao);
    
}
