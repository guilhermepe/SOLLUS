package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.ModeloEquipamento;

/**
 *
 * @author guiper
 */
public interface ModeloEquipamentoRepository extends CrudRepository<ModeloEquipamento, Integer>{
    
    List<ModeloEquipamento> findByNome(String nome);
    
}
