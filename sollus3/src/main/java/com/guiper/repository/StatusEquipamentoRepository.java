package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.StatusEquipamento;

/**
 *
 * @author guiper
 */
public interface StatusEquipamentoRepository extends CrudRepository<StatusEquipamento, Integer>{
    
    List<StatusEquipamento> findByStatus(String status);
    
}
