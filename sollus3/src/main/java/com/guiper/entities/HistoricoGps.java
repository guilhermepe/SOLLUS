
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
@Table(name = "historicogps")
public class HistoricoGps implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem   
   @Column(name = "idequipamento")
   private long idEquipamento;   
   private float latitude;
   private float longitude;    
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHora")
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private Date dataHora;

    public HistoricoGps() {
    }

    public HistoricoGps(long id, long idEquipamento, float latitude, float longitude, Date dataHora) {
        this.id = id;
        this.idEquipamento = idEquipamento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "HistoricoGps[" + "id=" + id + ", idEquipamento=" + idEquipamento + ", latitude=" + latitude + ", longitude=" + longitude + ", dataHora=" + dataHora + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
   
   
     
}

