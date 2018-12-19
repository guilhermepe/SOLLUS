
package com.guiper.entities;

import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
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
@Table(name = "historicorecente_sd")
public class HistoricoRecenteSd implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;   
   @Column(name = "idporta")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private long idPorta;
    @Column(name = "valorPorta")
   private int valorPorta;
   private int alarme;   
   private int acionada; 
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHora")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date dataHora;

    public HistoricoRecenteSd() {
    }

    public HistoricoRecenteSd(long id, long idPorta, int valorPorta, int alarme, int acionada, Date dataHora) {
        this.id = id;
        this.idPorta = idPorta;
        this.valorPorta = valorPorta;
        this.alarme = alarme;
        this.acionada = acionada;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "HistoricoRecenteSd[" + "id=" + id + ", idPorta=" + idPorta + ", valorPorta=" + valorPorta + ", alarme=" + alarme + ", acionada=" + acionada + ", dataHora=" + dataHora + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPorta() {
        return idPorta;
    }

    public void setIdPorta(long idPorta) {
        this.idPorta = idPorta;
    }

    public float getValorPorta() {
        return valorPorta;
    }

    public void setValorPorta(int valorPorta) {
        this.valorPorta = valorPorta;
    }

    public int getAlarme() {
        return alarme;
    }

    public void setAlarme(int alarme) {
        this.alarme = alarme;
    }

    public int getAcionada() {
        return acionada;
    }

    public void setAcionada(int acionada) {
        this.acionada = acionada;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
   
}
