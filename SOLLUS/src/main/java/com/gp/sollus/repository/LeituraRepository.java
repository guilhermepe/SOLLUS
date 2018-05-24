/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.Leitura;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */

@Repository("LeituraRepository")
public interface LeituraRepository extends JpaRepository<Leitura, Long> {
    Leitura findByPortasIdPortas(Long portasIdPortas);
    List<Leitura> findByDataHoraBetween(Date startDate,Date endDate);
    List<Leitura> findByDataHoraBetweenAndPortasIdPortas(Date startDate,Date endDate,Long portasIdPortas);
}
