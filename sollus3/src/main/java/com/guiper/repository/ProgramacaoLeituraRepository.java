package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.ProgramacaoLeitura;

/**
 *
 * @author guiper
 */
public interface ProgramacaoLeituraRepository extends CrudRepository<ProgramacaoLeitura, Integer>{
    
    List<ProgramacaoLeitura> findByIdEquipamento(long idEquipamento);
    
}
