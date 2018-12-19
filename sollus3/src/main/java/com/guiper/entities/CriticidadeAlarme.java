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
@Table(name = "criticidadealarme")
public class CriticidadeAlarme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String severidade;

    public CriticidadeAlarme() {
    }

    public CriticidadeAlarme(int id, String severidade) {
        this.id = id;
        this.severidade = severidade;
    }

    @Override
    public String toString() {
        return "CriticidadeAlarme[" + "id=" + id + ", severidade=" + severidade + ']';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }
    
}

