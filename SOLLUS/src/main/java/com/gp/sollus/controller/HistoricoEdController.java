/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.controller;

import com.gp.sollus.model.HistoricoEd;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gp.sollus.repository.HistoricoEdRepository;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author guiper
 */

@RestController
@RequestMapping("/historicoed")
public class HistoricoEdController {

    private HistoricoEdRepository hr;
    

    @Autowired
    public void setHistoricoEdService(HistoricoEdRepository hr) {
        this.hr = hr;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<HistoricoEd>> getAllHistoricoEd() {
        return new ResponseEntity<>((Collection<HistoricoEd>) hr.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, params = {"start","end"})
    public ResponseEntity<Collection<HistoricoEd>> getHistoricoEdBetween(
            @RequestParam(value="start")String start,
            @RequestParam(value="end") String end) {         
        Date startDate,endDate;        
        try {
            startDate = java.sql.Timestamp.valueOf( start );
        } catch (Exception ex) {
            startDate = java.sql.Timestamp.valueOf( start+" 00:00:00" );
        }        
        try {
            endDate = java.sql.Timestamp.valueOf( end );
        } catch (Exception ex) {
            endDate = java.sql.Timestamp.valueOf( end+" 23:59:59" );
        }
        return new ResponseEntity<>((Collection<HistoricoEd>) hr.findByDataHoraBetween(startDate,endDate),HttpStatus.OK);    
    }
    
    @RequestMapping(method = RequestMethod.GET, params = {"idporta","start","end"})
    public ResponseEntity<Collection<HistoricoEd>> getHistoricoEdBetweenAndIdPorta(
            @RequestParam(value="idporta")Long idporta,
            @RequestParam(value="start")String start,
            @RequestParam(value="end") String end) {         
        Date startDate,endDate;        
        try {
            startDate = java.sql.Timestamp.valueOf( start );
        } catch (Exception ex) {
            startDate = java.sql.Timestamp.valueOf( start+" 00:00:00" );
        }        
        try {
            endDate = java.sql.Timestamp.valueOf( end );
        } catch (Exception ex) {
            endDate = java.sql.Timestamp.valueOf( end+" 23:59:59" );
        }
        return new ResponseEntity<>((Collection<HistoricoEd>) hr.findByDataHoraBetweenAndIdPorta(startDate,endDate,idporta),HttpStatus.OK);    
    }

    @RequestMapping(method = RequestMethod.GET, params = {"page", "size"})
    public ResponseEntity<Page<HistoricoEd>> getAllHistoricoEd(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {        
        return new ResponseEntity<>((Page<HistoricoEd>) hr.findAll(new PageRequest(page, size)), HttpStatus.OK);
    }    
    
    @RequestMapping(method = RequestMethod.GET, params = {"page", "size","direction","property"})
    public ResponseEntity<Page<HistoricoEd>> getAllHistoricoEd(
            @RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
            @RequestParam(value = "direction") String dir, @RequestParam(value = "property") String prop) {        
        Sort s = new Sort(Sort.Direction.fromString(dir),prop);        
        return new ResponseEntity<>((Page<HistoricoEd>) hr.findAll(new PageRequest(page, size,s)), HttpStatus.OK);
    }

}