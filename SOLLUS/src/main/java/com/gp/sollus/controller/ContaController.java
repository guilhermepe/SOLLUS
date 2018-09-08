/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.controller;

import com.gp.sollus.model.Conta;
import com.gp.sollus.repository.ContaRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guiper
 */
@RestController
@RequestMapping("/conta")
public class ContaController {

    private ContaRepository cr;
   
    @Autowired
    public void setContaService(ContaRepository cr) {
        this.cr = cr;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Conta>> getAllConta() {
        return new ResponseEntity<>((Collection<Conta>) cr.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<Conta>> getAllConta(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {        
        return new ResponseEntity<>((Page<Conta>) cr.findAll(new PageRequest(page, size)), HttpStatus.OK);
    }

}
