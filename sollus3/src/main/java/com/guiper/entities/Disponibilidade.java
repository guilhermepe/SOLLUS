package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "alarmes")
public class Disponibilidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idservidor")
    private int idServidor;
    private String servico;   
    @Column(name = "datahoraqueda")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraQueda;
    @Column(name = "datahoravolta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraVolta;
    @Column(name = "statusalarmesms")
    private int statusAlarmeSms;
    @Column(name = "statusalarmeemail")
    private int statusAlarmeEmail;

    public Disponibilidade() {
    }

    public Disponibilidade(Long id, int idServidor, String servico, Date dataHoraQueda, Date dataHoraVolta, int statusAlarmeSms, int statusAlarmeEmail) {
        this.id = id;
        this.idServidor = idServidor;
        this.servico = servico;
        this.dataHoraQueda = dataHoraQueda;
        this.dataHoraVolta = dataHoraVolta;
        this.statusAlarmeSms = statusAlarmeSms;
        this.statusAlarmeEmail = statusAlarmeEmail;
    }

    @Override
    public String toString() {
        return "Disponibilidade[" + "id=" + id + ", idServidor=" + idServidor + ", servico=" + servico + ", dataHoraQueda=" + dataHoraQueda + ", dataHoraVolta=" + dataHoraVolta + ", statusAlarmeSms=" + statusAlarmeSms + ", statusAlarmeEmail=" + statusAlarmeEmail + ']';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Date getDataHoraQueda() {
        return dataHoraQueda;
    }

    public void setDataHoraQueda(Date dataHoraQueda) {
        this.dataHoraQueda = dataHoraQueda;
    }

    public Date getDataHoraVolta() {
        return dataHoraVolta;
    }

    public void setDataHoraVolta(Date dataHoraVolta) {
        this.dataHoraVolta = dataHoraVolta;
    }

    public int getStatusAlarmeSms() {
        return statusAlarmeSms;
    }

    public void setStatusAlarmeSms(int statusAlarmeSms) {
        this.statusAlarmeSms = statusAlarmeSms;
    }

    public int getStatusAlarmeEmail() {
        return statusAlarmeEmail;
    }

    public void setStatusAlarmeEmail(int statusAlarmeEmail) {
        this.statusAlarmeEmail = statusAlarmeEmail;
    }
    
}

