/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.HistoricoRecenteEd;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricoRecenteEdRepository")
public interface HistoricoRecenteEdRepository extends JpaRepository<HistoricoRecenteEd, Long> {
    HistoricoRecenteEd findByIdPorta(Long idPorta);
    List<HistoricoRecenteEd> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoRecenteEd> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
}
