package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.Usuario;

/**
 *
 * @author guiper
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
    List<Usuario> findByLogin(String login);
    List<Usuario> findByNivel(String nivel);
    List<Usuario> findByHabilitado(int habilitado);
    
}
