package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Disponibilidade;

/**
 *
 * @author guiper
 */
public interface DisponibilidadeRepository extends CrudRepository<Disponibilidade, Integer>{
    
    List<Disponibilidade> findById(Long id);
}
