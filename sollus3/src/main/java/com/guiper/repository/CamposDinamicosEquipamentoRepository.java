package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.CamposDinamicosEquipamento;

/**
 *
 * @author guiper
 */
public interface CamposDinamicosEquipamentoRepository extends CrudRepository<CamposDinamicosEquipamento, Integer>{
    
    List<CamposDinamicosEquipamento> findByVariavel(String variavel);
    
}
