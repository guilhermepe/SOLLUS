package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.TipoConexao;

/**
 *
 * @author guiper
 */
public interface TipoConexaoRepository extends CrudRepository<TipoConexao, Integer>{
    
    List<TipoConexao> findByTipoConexao(String tipoConexao);
    
}
