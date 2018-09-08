/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.repository;

import com.gp.sollus.model.ModeloEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guiper
 */
@Repository("ModeloEquipamentoRepository")
public interface ModeloEquipamentoRepository extends JpaRepository<ModeloEquipamento, Long> {
     
}
