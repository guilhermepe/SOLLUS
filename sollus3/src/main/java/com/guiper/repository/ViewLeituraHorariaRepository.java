package com.guiper.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.guiper.entities.ViewLeituraHoraria;

/**
 *
 * @author guiper
 */
public interface ViewLeituraHorariaRepository extends CrudRepository<ViewLeituraHoraria, Integer>{
    
    List<ViewLeituraHoraria> findByEquipamentoId(Long equipamentoId);
    List<ViewLeituraHoraria> findByPortaId(Long portaId);
    
}
