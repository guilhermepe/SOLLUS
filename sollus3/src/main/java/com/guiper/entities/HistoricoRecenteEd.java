
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
@Table(name = "historicorecenteEd")
public class HistoricoRecenteEd implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem   
   @Column(name = "idporta")
   private long idPorta;   
   @Column(name = "valorPorta")
   private int valorPorta;
   private int alarme;   
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHora")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date dataHora;

    public HistoricoRecenteEd() {
    }

    public HistoricoRecenteEd(long id, long idPorta, int valorPorta, int alarme, Date dataHora) {
        this.id = id;
        this.idPorta = idPorta;
        this.valorPorta = valorPorta;
        this.alarme = alarme;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "HistoricoRecenteEd[" + "id=" + id + ", idPorta=" + idPorta + ", valorPorta=" + valorPorta + ", alarme=" + alarme + ", dataHora=" + dataHora + ']';
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
     
}
