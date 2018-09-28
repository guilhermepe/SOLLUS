package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.TipoPorta;

/**
 *
 * @author guiper
 */
public interface TipoPortaRepository extends CrudRepository<TipoPorta, Integer>{
    
    List<TipoPorta> findByNome(String nome);
    
}
