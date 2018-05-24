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
@Table
public class Leitura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="portasIdportas")
    private long portasIdPortas;
    private int alarme;
    private int tp;
    private float valorPorta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHora;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimaVariacao;

    public long getId() {
        return id;
    }

    public long getPortasIdPortas() {
        return portasIdPortas;
    }

    public int getAlarme() {
        return alarme;
    }

    public int getTp() {
        return tp;
    }

    public float getValorPorta() {
        return valorPorta;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Date getUltimaVariacao() {
        return ultimaVariacao;
    }

}
