/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.HistoricoSd;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("HistoricosdRepository")
public interface HistoricoSdRepository extends JpaRepository<HistoricoSd, Long> {
    HistoricoSd findByIdPorta(Long idPorta);
    List<HistoricoSd> findByDataHoraBetween(Date startDate,Date endDate);
    List<HistoricoSd> findByDataHoraBetweenAndIdPorta(Date startDate,Date endDate,Long idporta);
}
