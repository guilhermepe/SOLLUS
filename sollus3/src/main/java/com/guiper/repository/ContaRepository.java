package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Conta;

/**
 *
 * @author guiper
 */
public interface ContaRepository extends CrudRepository<Conta, Integer>{
    
    List<Conta> findByNome(String nome);
    
}
