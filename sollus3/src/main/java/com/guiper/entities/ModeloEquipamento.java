package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "modeloequipamento")
public class ModeloEquipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String nome;

    public ModeloEquipamento() {
    }

    public ModeloEquipamento(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

