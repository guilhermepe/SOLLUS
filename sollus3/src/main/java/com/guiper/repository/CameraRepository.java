package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Camera;

/**
 *
 * @author guiper
 */
public interface CameraRepository extends CrudRepository<Camera, Integer>{
    
    List<Camera> findByNome(String nome);
    
}
