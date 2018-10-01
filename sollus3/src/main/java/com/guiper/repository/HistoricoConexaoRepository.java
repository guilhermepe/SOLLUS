package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoConexao;

/**
 *
 * @author guiper
 */
public interface HistoricoConexaoRepository extends CrudRepository<HistoricoConexao, Integer>{
    
    List<HistoricoConexao> findByIdEquipamento(Long idEquipamento);
    
}
