package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Leitura;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface LeituraRepository extends CrudRepository<Leitura, Integer>{
    
    List<Leitura> findByDataHora(Date dataHora);
    
}
