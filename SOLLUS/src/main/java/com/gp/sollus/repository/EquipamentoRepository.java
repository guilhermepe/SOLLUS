/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.Equipamento;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */
@Repository("EquipamentoRepository")
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {   
    List<Equipamento> findByNomeLike(String nome);
    List<Equipamento> findByDataHoraBetween(Date startDate,Date endDate);
}
