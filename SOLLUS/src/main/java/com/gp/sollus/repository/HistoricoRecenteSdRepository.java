/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.HistoricoRecenteSd;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricoRecenteSdRepository")
public interface HistoricoRecenteSdRepository extends JpaRepository<HistoricoRecenteSd, Long> {
    HistoricoRecenteSd findByIdPorta(Long idPorta);
    List<HistoricoRecenteSd> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoRecenteSd> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
}
