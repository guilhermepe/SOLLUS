package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.HistoricoLogin;
import java.util.Date;

/**
 *
 * @author guiper
 */
public interface HistoricoLoginRepository extends CrudRepository<HistoricoLogin, Integer>{
    
    List<HistoricoLogin> findByDataHora(Date dataHora);
    List<HistoricoLogin> findByIdUsuario(Long idUsuario);
    
}
