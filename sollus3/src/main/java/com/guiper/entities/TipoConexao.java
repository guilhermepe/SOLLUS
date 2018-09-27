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
@Table(name = "tipoconexaoequipamento")
public class TipoConexao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    @Column(name = "tipoconexao")
    private String tipoConexao;

    public TipoConexao() {
    }

    public TipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    @Override
    public String toString() {
        return "TipoConexao[" + "id=" + id + ", tipoConexao=" + tipoConexao + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }
    
}

