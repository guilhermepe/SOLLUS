package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.PortasTcp;

/**
 *
 * @author guiper
 */
public interface PortaTcpRepository extends CrudRepository<PortasTcp, Integer>{
    
    List<PortasTcp> findByDisponivel(int disponivel);
    
}
