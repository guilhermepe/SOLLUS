
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
@Table(name = "historicologin")
public class HistoricoLogin implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)   
   private long id;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem   
   @Column(name = "idusuario")
   private long idUsuario;    
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHoraLogin")
   private Date dataHoraLogin;     
   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   @Column(name = "dataHoraLogout")
   private Date dataHoraLogout; 
   private String acoes;

    public HistoricoLogin() {
    }

    public HistoricoLogin(long id, long idUsuario, Date dataHoraLogin, Date dataHoraLogout, String acoes) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataHoraLogin = dataHoraLogin;
        this.dataHoraLogout = dataHoraLogout;
        this.acoes = acoes;
    }

    @Override
    public String toString() {
        return "HistoricoLogin[" + "id=" + id + ", idUsuario=" + idUsuario + ", dataHoraLogin=" + dataHoraLogin + ", dataHoraLogout=" + dataHoraLogout + ", acoes=" + acoes + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataHoraLogin() {
        return dataHoraLogin;
    }

    public void setDataHoraLogin(Date dataHoraLogin) {
        this.dataHoraLogin = dataHoraLogin;
    }

    public Date getDataHoraLogout() {
        return dataHoraLogout;
    }

    public void setDataHoraLogout(Date dataHoraLogout) {
        this.dataHoraLogout = dataHoraLogout;
    }

    public String getAcoes() {
        return acoes;
    }

    public void setAcoes(String acoes) {
        this.acoes = acoes;
    }
   
}

