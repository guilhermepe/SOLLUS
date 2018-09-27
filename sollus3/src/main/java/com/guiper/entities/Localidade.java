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
@Table(name = "localidade")
public class Localidade implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;        
    private long idConta;
    @Column(name = "nomelocalidade")
    @Sap(filterable=true, sortable=true)
    @SAPLineItem    
    private String nomeLocalidade;
    private long pai;   

    public Localidade(long id, long idConta, String nomeLocalidade, long pai) {
        this.id = id;
        this.idConta = idConta;
        this.nomeLocalidade = nomeLocalidade;
        this.pai = pai;
    }

    public Localidade() {
    }

    @Override
    public String toString() {
        return "Localidade[" + "id=" + id + ", idConta=" + idConta + ", nomeLocalidade=" + nomeLocalidade + ", pai=" + pai + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdConta() {
        return idConta;
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public long getPai() {
        return pai;
    }

    public void setPai(long pai) {
        this.pai = pai;
    }
    
    
}

