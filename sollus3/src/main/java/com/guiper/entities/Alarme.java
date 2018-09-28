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
public class Alarme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    @Column(name = "idporta")
    private long idPorta;
    private String comentario;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    @Column(name = "loginrecalarme")
    private String loginRecAlarme;  
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    @Column(name = "loginrecnormal")
    private String loginRecNormal;
    @Column(name = "horarioDisparo")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date horarioDisparo;
    @Column(name = "horarioNormalizacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date horarioNormalizacao;
    @Column(name = "reconhecimentoNormalizacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date reconhecimentoNormalizacao;
    @Column(name = "idcriticidade")
    private int idCriticidade;
    @Column(name = "valorDisparo")
    private float valorDisparo;
    @Column(name = "valorNormalizado")
    private float valorNormalizado; 

    public Alarme() {
    }

    public Alarme(long id, long idPorta, String comentario, String loginRecAlarme, String loginRecNormal, Date horarioDisparo, Date horarioNormalizacao, Date reconhecimentoNormalizacao, int idCriticidade, float valorDisparo, float valorNormalizado) {
        this.id = id;
        this.idPorta = idPorta;
        this.comentario = comentario;
        this.loginRecAlarme = loginRecAlarme;
        this.loginRecNormal = loginRecNormal;
        this.horarioDisparo = horarioDisparo;
        this.horarioNormalizacao = horarioNormalizacao;
        this.reconhecimentoNormalizacao = reconhecimentoNormalizacao;
        this.idCriticidade = idCriticidade;
        this.valorDisparo = valorDisparo;
        this.valorNormalizado = valorNormalizado;
    }

    @Override
    public String toString() {
        return "Alarme[" + "id=" + id + ", idPorta=" + idPorta + ", comentario=" + comentario + ", loginRecAlarme=" + loginRecAlarme + ", loginRecNormal=" + loginRecNormal + ", horarioDisparo=" + horarioDisparo + ", horarioNormalizacao=" + horarioNormalizacao + ", reconhecimentoNormalizacao=" + reconhecimentoNormalizacao + ", idCriticidade=" + idCriticidade + ", valorDisparo=" + valorDisparo + ", valorNormalizado=" + valorNormalizado + ']';
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLoginRecAlarme() {
        return loginRecAlarme;
    }

    public void setLoginRecAlarme(String loginRecAlarme) {
        this.loginRecAlarme = loginRecAlarme;
    }

    public String getLoginRecNormal() {
        return loginRecNormal;
    }

    public void setLoginRecNormal(String loginRecNormal) {
        this.loginRecNormal = loginRecNormal;
    }

    public Date getHorarioDisparo() {
        return horarioDisparo;
    }

    public void setHorarioDisparo(Date horarioDisparo) {
        this.horarioDisparo = horarioDisparo;
    }

    public Date getHorarioNormalizacao() {
        return horarioNormalizacao;
    }

    public void setHorarioNormalizacao(Date horarioNormalizacao) {
        this.horarioNormalizacao = horarioNormalizacao;
    }

    public Date getReconhecimentoNormalizacao() {
        return reconhecimentoNormalizacao;
    }

    public void setReconhecimentoNormalizacao(Date reconhecimentoNormalizacao) {
        this.reconhecimentoNormalizacao = reconhecimentoNormalizacao;
    }

    public int getIdCriticidade() {
        return idCriticidade;
    }

    public void setIdCriticidade(int idCriticidade) {
        this.idCriticidade = idCriticidade;
    }

    public float getValorDisparo() {
        return valorDisparo;
    }

    public void setValorDisparo(float valorDisparo) {
        this.valorDisparo = valorDisparo;
    }

    public float getValorNormalizado() {
        return valorNormalizado;
    }

    public void setValorNormalizado(float valorNormalizado) {
        this.valorNormalizado = valorNormalizado;
    }
   
}

