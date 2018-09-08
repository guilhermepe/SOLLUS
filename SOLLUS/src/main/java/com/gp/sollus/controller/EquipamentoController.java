/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.controller;

import com.gp.sollus.model.Equipamento;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gp.sollus.repository.EquipamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author guiper
 */

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private EquipamentoRepository hr;
    

    @Autowired
    public void setEquipamentoService(EquipamentoRepository hr) {
        this.hr = hr;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Equipamento>> getAllEquipamento() {
        return new ResponseEntity<>((Collection<Equipamento>) hr.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, params = {"nome"})
    public ResponseEntity<Collection<Equipamento>> findByNomeLike(@RequestParam(value = "nome") String nome) {
        return new ResponseEntity<>((Collection<Equipamento>) hr.findByNomeLike(nome), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<Equipamento>> getAllEquipamento(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {        
        return new ResponseEntity<>((Page<Equipamento>) hr.findAll(new PageRequest(page, size)), HttpStatus.OK);
    }    
    
    @RequestMapping(method = RequestMethod.GET, params = {"page", "size","direction","property"})
    public ResponseEntity<Page<Equipamento>> getAllEquipamento(
            @RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
            @RequestParam(value = "direction") String dir, @RequestParam(value = "property") String prop) {        
        Sort s = new Sort(Sort.Direction.fromString(dir),prop);        
        return new ResponseEntity<>((Page<Equipamento>) hr.findAll(new PageRequest(page, size,s)), HttpStatus.OK);
    }

}
