/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.HistoricoEa;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricoEaRepository")
public interface HistoricoEaRepository extends JpaRepository<HistoricoEa, Long> {
    
       
    HistoricoEa findByIdPorta(Long idPorta);
    List<HistoricoEa> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoEa> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
    //List<HistoricoEa> findByDataHoraBetweenAndIdPortaIn(Date startDate,Date endDate,List<Long> idporta);
    List<HistoricoEa> findByIdPortaIn(List<Long> idporta);
}
