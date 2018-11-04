package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "v_leitura_recente")
public class ViewLeituraRecente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private long portaId; 
    @Sap(filterable=true, sortable=true)
    @SAPLineItem       
    private long equipamentoId;
    private String equipamentoNome;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String portaNome;      
    private float valorPorta;    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;
    private String portaUnidade;

    public ViewLeituraRecente() {
    }

    public ViewLeituraRecente(long portaId, long equipamentoId, String equipamentoNome, String portaNome, float valorPorta, Date dataHora, String portaUnidade) {
        this.portaId = portaId;
        this.equipamentoId = equipamentoId;
        this.equipamentoNome = equipamentoNome;
        this.portaNome = portaNome;
        this.valorPorta = valorPorta;
        this.dataHora = dataHora;
        this.portaUnidade = portaUnidade;
    }

    @Override
    public String toString() {
        return "ViewLeituraRecente[" + "portaId=" + portaId + ", equipamentoId=" + equipamentoId + ", equipamentoNome=" + equipamentoNome + ", portaNome=" + portaNome + ", valorPorta=" + valorPorta + ", dataHora=" + dataHora + ", portaUnidade=" + portaUnidade + ']';
    }    

    public long getPortaId() {
        return portaId;
    }

    public void setPortaId(long portaId) {
        this.portaId = portaId;
    }

    public long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getEquipamentoNome() {
        return equipamentoNome;
    }

    public void setEquipamentoNome(String equipamentoNome) {
        this.equipamentoNome = equipamentoNome;
    }

    public String getPortaNome() {
        return portaNome;
    }

    public void setPortaNome(String portaNome) {
        this.portaNome = portaNome;
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

    public String getPortaUnidade() {
        return portaUnidade;
    }

    public void setPortaUnidade(String portaUnidade) {
        this.portaUnidade = portaUnidade;
    }
    
    
       
}

