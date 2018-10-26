
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
@Table(name = "historico_ea_diario")
public class HistoricoEaDiario implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem      
   private long idPorta;   
   private String nomePorta;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem   
   private long idEquipamento;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem   
   private String nomeEquipamento;
   private long idConta;
   private String nomeConta;
   private float valorPortaInicial;
   private float valorPortaFinal;
   private float valorPortaDelta;
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date diaRegistro;

    public HistoricoEaDiario() {
    }

    public HistoricoEaDiario(long id, long idPorta, String nomePorta, long idEquipamento, String nomeEquipamento, long idConta, String nomeConta, float valorPortaInicial, float valorPortaFinal, float valorPortaDelta, Date diaRegistro) {
        this.id = id;
        this.idPorta = idPorta;
        this.nomePorta = nomePorta;
        this.idEquipamento = idEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.idConta = idConta;
        this.nomeConta = nomeConta;
        this.valorPortaInicial = valorPortaInicial;
        this.valorPortaFinal = valorPortaFinal;
        this.valorPortaDelta = valorPortaDelta;
        this.diaRegistro = diaRegistro;
    }

    @Override
    public String toString() {
        return "HistoricoEaDiario[" + "id=" + id + ", idPorta=" + idPorta + ", nomePorta=" + nomePorta + ", idEquipamento=" + idEquipamento + ", nomeEquipamento=" + nomeEquipamento + ", idConta=" + idConta + ", nomeConta=" + nomeConta + ", valorPortaInicial=" + valorPortaInicial + ", valorPortaFinal=" + valorPortaFinal + ", valorPortaDelta=" + valorPortaDelta + ", diaRegistro=" + diaRegistro + ']';
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

    public String getNomePorta() {
        return nomePorta;
    }

    public void setNomePorta(String nomePorta) {
        this.nomePorta = nomePorta;
    }

    public long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public long getIdConta() {
        return idConta;
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public float getValorPortaInicial() {
        return valorPortaInicial;
    }

    public void setValorPortaInicial(float valorPortaInicial) {
        this.valorPortaInicial = valorPortaInicial;
    }

    public float getValorPortaFinal() {
        return valorPortaFinal;
    }

    public void setValorPortaFinal(float valorPortaFinal) {
        this.valorPortaFinal = valorPortaFinal;
    }

    public float getValorPortaDelta() {
        return valorPortaDelta;
    }

    public void setValorPortaDelta(float valorPortaDelta) {
        this.valorPortaDelta = valorPortaDelta;
    }

    public Date getDiaRegistro() {
        return diaRegistro;
    }

    public void setDiaRegistro(Date diaRegistro) {
        this.diaRegistro = diaRegistro;
    }
   
  
}
