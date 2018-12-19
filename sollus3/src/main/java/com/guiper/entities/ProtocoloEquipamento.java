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
@Table(name = "protocoloequipamento")
public class ProtocoloEquipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    @Column(name = "nome")
    private String nome;
    
    public ProtocoloEquipamento(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public ProtocoloEquipamento() {
    }

    @Override
    public String toString() {
        return "ProtocoloEquipamento[" + "id=" + id + ", nome=" + nome + ']';
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

