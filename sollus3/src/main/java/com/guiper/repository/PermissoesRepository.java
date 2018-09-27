package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Permissoes;

/**
 *
 * @author guiper
 */
public interface PermissoesRepository extends CrudRepository<Permissoes, Integer>{
    
    List<Permissoes> findByIdUsuario(Long idUsuario);
    
}
