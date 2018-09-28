package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author guiper
 */
@Entity
@Table(name = "campos_dinamicos_equipamento")
public class CamposDinamicosEquipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "equipamentoId")
    private Long equipamentoId;
    @Sap(filterable = true, sortable = true)
    @SAPLineItem
    private String variavel;
    private String valor;

    public CamposDinamicosEquipamento() {
    }

    public CamposDinamicosEquipamento(long id, Long equipamentoId, String variavel, String valor) {
        this.id = id;
        this.equipamentoId = equipamentoId;
        this.variavel = variavel;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CamposDinamicosEquipamento[" + "id=" + id + ", equipamentoId=" + equipamentoId + ", variavel=" + variavel + ", valor=" + valor + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
   
}
