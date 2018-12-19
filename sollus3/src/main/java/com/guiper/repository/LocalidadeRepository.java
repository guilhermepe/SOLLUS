package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Localidade;

/**
 *
 * @author guiper
 */
public interface LocalidadeRepository extends CrudRepository<Localidade, Integer>{
    
    List<Localidade> findByNomeLocalidade(String nomeLocalidade);
    
}
