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
@Table(name = "tipoAlarme")
public class TipoAlarme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    @Column(name = "tipoAlarmeDescricao")
    private String tipoAlarmeDescricao;
    private int valor;

    public TipoAlarme() {
    }

    public TipoAlarme(long id, String tipoAlarmeDescricao, int valor) {
        this.id = id;
        this.tipoAlarmeDescricao = tipoAlarmeDescricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "TipoAlarme[" + "id=" + id + ", tipoAlarmeDescricao=" + tipoAlarmeDescricao + ", valor=" + valor + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoAlarmeDescricao() {
        return tipoAlarmeDescricao;
    }

    public void setTipoAlarmeDescricao(String tipoAlarmeDescricao) {
        this.tipoAlarmeDescricao = tipoAlarmeDescricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}

