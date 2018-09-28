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
@Table(name = "horarioleitura")
public class HorarioLeitura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "idporta")
    private long idPorta;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "dataHora")
    @Sap(filterable = true, sortable = true)
    @SAPLineItem
    private Date dataHora;

    public HorarioLeitura() {
    }

    public HorarioLeitura(long id, long idPorta, Date dataHora) {
        this.id = id;
        this.idPorta = idPorta;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "HorarioLeitura[" + "id=" + id + ", idPorta=" + idPorta + ", dataHora=" + dataHora + ']';
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

}
