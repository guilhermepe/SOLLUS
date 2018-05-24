/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;


import com.gp.sollus.model.HistoricoEa;
import com.gp.sollus.model.HistoricoRecenteEa;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricoRecenteEaRepository")
public interface HistoricoRecenteEaRepository extends JpaRepository<HistoricoRecenteEa, Long> {
    HistoricoRecenteEa findByIdPorta(Long idPorta);
    List<HistoricoRecenteEa> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoRecenteEa> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
}
