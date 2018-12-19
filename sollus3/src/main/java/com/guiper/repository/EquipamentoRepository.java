package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Equipamento;

/**
 *
 * @author guiper
 */
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer>{
    
    List<Equipamento> findByNome(String nome);
    
}
