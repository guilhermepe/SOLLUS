
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
@Table(name = "leitura")
public class Leitura implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;   
   @Column(name = "portasIdportas")
   private long idPorta;
   private int alarme;
   private int tp;
   @Column(name = "valorPorta")
   private float valorPorta;
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHora")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date dataHora;
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "ultimaVariacao")   
   private Date ultimaVariacao;

    public Leitura() {
    } 

    public Leitura(long id, long idPorta, int alarme, int tp, float valorPorta, Date dataHora, Date ultimaVariacao) {
        this.id = id;
        this.idPorta = idPorta;
        this.alarme = alarme;
        this.tp = tp;
        this.valorPorta = valorPorta;
        this.dataHora = dataHora;
        this.ultimaVariacao = ultimaVariacao;
    }

    @Override
    public String toString() {
        return "Leitura[" + "id=" + id + ", idPorta=" + idPorta + ", alarme=" + alarme + ", tp=" + tp + ", valorPorta=" + valorPorta + ", dataHora=" + dataHora + ", ultimaVariacao=" + ultimaVariacao + ']';
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

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
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

    public Date getUltimaVariacao() {
        return ultimaVariacao;
    }

    public void setUltimaVariacao(Date ultimaVariacao) {
        this.ultimaVariacao = ultimaVariacao;
    }
    
}
