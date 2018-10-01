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
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "contasId")
    private long contaId;
    private String nome;
    @Column(name = "celsms")
    private String celSms;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String login;
    private String senha;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String nivel;
    @Column(name = "emailalarme")    
    private int emailAlarme;
    @Column(name = "endemail")   
    private String endEmail;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private int habilitado;
    @Column(name = "smsalarme")    
    private int smsAlarme;
    private String contato; 
    @Column(name = "ultimoLogin")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ultimoLogin;
    private int excluido;

    public Usuario() {
    }

    public Usuario(long id, long contaId, String nome, String celSms, String login, String senha, String nivel, int emailAlarme, String endEmail, int habilitado, int smsAlarme, String contato, Date ultimoLogin, int excluido) {
        this.id = id;
        this.contaId = contaId;
        this.nome = nome;
        this.celSms = celSms;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.emailAlarme = emailAlarme;
        this.endEmail = endEmail;
        this.habilitado = habilitado;
        this.smsAlarme = smsAlarme;
        this.contato = contato;
        this.ultimoLogin = ultimoLogin;
        this.excluido = excluido;
    }

    @Override
    public String toString() {
        return "Usuario[" + "id=" + id + ", contaId=" + contaId + ", nome=" + nome + ", celSms=" + celSms + ", login=" + login + ", senha=" + senha + ", nivel=" + nivel + ", emailAlarme=" + emailAlarme + ", endEmail=" + endEmail + ", habilitado=" + habilitado + ", smsAlarme=" + smsAlarme + ", contato=" + contato + ", ultimoLogin=" + ultimoLogin + ", excluido=" + excluido + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContaId() {
        return contaId;
    }

    public void setContaId(long contaId) {
        this.contaId = contaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelSms() {
        return celSms;
    }

    public void setCelSms(String celSms) {
        this.celSms = celSms;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getEmailAlarme() {
        return emailAlarme;
    }

    public void setEmailAlarme(int emailAlarme) {
        this.emailAlarme = emailAlarme;
    }

    public String getEndEmail() {
        return endEmail;
    }

    public void setEndEmail(String endEmail) {
        this.endEmail = endEmail;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public int getSmsAlarme() {
        return smsAlarme;
    }

    public void setSmsAlarme(int smsAlarme) {
        this.smsAlarme = smsAlarme;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public int getExcluido() {
        return excluido;
    }

    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }
    
}

