/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.controller;

import com.gp.sollus.model.StatusEquipamento;
import com.gp.sollus.repository.StatusEquipamentoRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guiper
 */

@RestController
@RequestMapping("/statusequipamento")
public class StatusEquipamentoController {
    private StatusEquipamentoRepository mr;
    
    @Autowired
    public void setStatusEquipamentoService(StatusEquipamentoRepository mr) {
        this.mr = mr;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<StatusEquipamento>> getAllStatusEquipamento() {
        return new ResponseEntity<> ((Collection <StatusEquipamento>) mr.findAll(), HttpStatus.OK);
    }
    
    
}
