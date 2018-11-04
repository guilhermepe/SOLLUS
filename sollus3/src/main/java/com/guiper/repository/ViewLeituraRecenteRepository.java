package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.ViewLeituraRecente;

/**
 *
 * @author guiper
 */
public interface ViewLeituraRecenteRepository extends CrudRepository<ViewLeituraRecente, Integer>{
    
    List<ViewLeituraRecente> findByEquipamentoId(Long equipamentoId);
   
    
}
