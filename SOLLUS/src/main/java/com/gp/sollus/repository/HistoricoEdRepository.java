/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.HistoricoEd;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricoEdRepository")
public interface HistoricoEdRepository extends JpaRepository<HistoricoEd, Long> {
    HistoricoEd findByIdPorta(Long idPorta);
    List<HistoricoEd> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoEd> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
}
