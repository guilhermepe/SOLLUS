package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.ProtocoloEquipamento;

/**
 *
 * @author guiper
 */
public interface ProtocoloEquipamentoRepository extends CrudRepository<ProtocoloEquipamento, Integer>{
    
    List<ProtocoloEquipamento> findByNome(String nome);
    
}
