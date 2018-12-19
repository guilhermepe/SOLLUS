package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Servidor;

/**
 *
 * @author guiper
 */
public interface ServidorRepository extends CrudRepository<Servidor, Integer>{
    
    List<Servidor> findByEndereco(String endereco);
    
}
