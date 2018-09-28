package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.EstatisticaConexao;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface EstatisticaConexaoRepository extends CrudRepository<EstatisticaConexao, Integer>{
    
    List<EstatisticaConexao> findByDataEstatistica(Date dataEstatistica);
    List<EstatisticaConexao> findByIdEquipamento(Long idEquipamento);
}
