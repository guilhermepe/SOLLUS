
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
@Table(name = "historico_tmp")
public class HistoricoTmp implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;   
   @Column(name = "idporta")
   private long idPorta;
   private int alarme;   
   @Column(name = "valorPorta")
   private float valorPorta;
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHora")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date dataHora;

    public HistoricoTmp() {
    }

    public HistoricoTmp(long id, long idPorta, int alarme, float valorPorta, Date dataHora) {
        this.id = id;
        this.idPorta = idPorta;
        this.alarme = alarme;
        this.valorPorta = valorPorta;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "HistoricoTmp[" + "id=" + id + ", idPorta=" + idPorta + ", alarme=" + alarme + ", valorPorta=" + valorPorta + ", dataHora=" + dataHora + ']';
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

    public int getAlarme() {
        return alarme;
    }

    public void setAlarme(int alarme) {
        this.alarme = alarme;
    }

    public float getValorPorta() {
        return valorPorta;
    }

    public void setValorPorta(float valorPorta) {
        this.valorPorta = valorPorta;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
   
}
