package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Porta;

/**
 *
 * @author guiper
 */
public interface PortaRepository extends CrudRepository<Porta, Integer>{
    
    List<Porta> findByNome(String nome);
    
}
