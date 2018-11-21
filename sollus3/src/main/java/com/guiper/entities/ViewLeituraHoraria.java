package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "v_leitura_horaria")
public class ViewLeituraHoraria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private long Id; 
    @Sap(filterable=true, sortable=true)
    @SAPLineItem       
    private long equipamentoId;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem       
    private long portaId;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String nome;      
    private float valorPorta;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;

    public ViewLeituraHoraria() {
    }

    public ViewLeituraHoraria(long Id, long equipamentoId, long portaId, String nome, float valorPorta, Date dataHora) {
        this.Id = Id;
        this.equipamentoId = equipamentoId;
        this.portaId = portaId;
        this.nome = nome;
        this.valorPorta = valorPorta;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "ViewLeituraHoraria[" + "Id=" + Id + ", equipamentoId=" + equipamentoId + ", portaId=" + portaId + ", nome=" + nome + ", valorPorta=" + valorPorta + ", dataHora=" + dataHora + ']';
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public long getPortaId() {
        return portaId;
    }

    public void setPortaId(long portaId) {
        this.portaId = portaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

