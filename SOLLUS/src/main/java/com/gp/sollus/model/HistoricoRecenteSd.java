/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author guiper
 */

@Entity
@Table (name="historicorecenteSd")
public class HistoricoRecenteSd implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="idporta")
    private long idPorta;
    private int valorPorta;
    private int alarme;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
      

    public long getId() {
        return id;
    }

    public long getIdPorta() {
        return idPorta;
    }

    public int getValorPorta() {
        return valorPorta;
    }

    public int getAlarme() {
        return alarme;
    }

    public Date getDataHora() {
        return dataHora;
    }

    
}
