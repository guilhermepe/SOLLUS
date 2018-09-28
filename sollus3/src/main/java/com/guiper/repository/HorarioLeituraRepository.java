package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HorarioLeitura;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HorarioLeituraRepository extends CrudRepository<HorarioLeitura, Integer>{
    
    List<HorarioLeitura> findByDataHora(Date dataHora);
    
}
