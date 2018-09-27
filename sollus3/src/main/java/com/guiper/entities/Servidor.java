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
@Table(name = "servidor")
public class Servidor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String endereco;
    private String protocolos;
    private int sms;
    private int email;
    @Column(name = "statussc")
    private int statusSc;    
    @Column(name = "horarioverao")
    private int horarioVerao;

    public Servidor() {
    }

    public Servidor(long id, String endereco, String protocolos, int sms, int email, int statusSc, int horarioVerao) {
        this.id = id;
        this.endereco = endereco;
        this.protocolos = protocolos;
        this.sms = sms;
        this.email = email;
        this.statusSc = statusSc;
        this.horarioVerao = horarioVerao;
    }

    @Override
    public String toString() {
        return "Servidor[" + "id=" + id + ", endereco=" + endereco + ", protocolos=" + protocolos + ", sms=" + sms + ", email=" + email + ", statusSc=" + statusSc + ", horarioVerao=" + horarioVerao + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(String protocolos) {
        this.protocolos = protocolos;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getStatusSc() {
        return statusSc;
    }

    public void setStatusSc(int statusSc) {
        this.statusSc = statusSc;
    }

    public int getHorarioVerao() {
        return horarioVerao;
    }

    public void setHorarioVerao(int horarioVerao) {
        this.horarioVerao = horarioVerao;
    }
    
}

