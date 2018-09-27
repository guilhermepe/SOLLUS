
package com.guiper.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "portas")
public class Porta implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idPortas")
   private long id;   
   @Column(name = "EquipamentoId")
   private long equipamentoId;
   @Column(name = "nivelalarme")
   private int nivelAlarme;
   private String nome;
   @Column(name = "habilitaalarme")
   private int habilitaAlarme;
   private int acionada;
   private String unidade;
   @Column(name = "limanin")
   private float limAnIn;
   @Column(name = "limansu")
   private float limAnSu;
   @Column(name = "intervaloleitura")
   private int intervaloLeitura;
   private String oid;
   private int alterar;
   @Column(name = "emailrelatorio")
   private int emailRelatorio;
   private String img;
   @Column(name = "alteroustatus")
   private int alterouStatus;
   private int sms;
   @Column(name = "tipoalarme")
   private int tipoAlarme;
   @Column(name = "tempoalarme")
   private String tempoAlarme;
   @Column(name = "emailalarme")
   private int emailAlarme;
   @Column(name = "mingrafico")
   private float minGrafico;
   @Column(name = "maxgrafico")
   private float maxGrafico;
   private int habilitada;
   @Column(name = "reconhecealarme")
   private int reconheceAlarme;
   private int filtro;
   @Column(name = "idtipoporta")
   private int idTipoPorta;
   private float constante;
   private float offset;
   //@Column(name = "numeroPorta")
   private int numeroPorta;
   @Column(name = "cfgacionamento")
   private String cfgAcionamento;
   @Column(name = "idcriticidade")
   private int idCriticidade;
   private int categoria;
   private int totalizar;

    public Porta(long equipamentoId, String nome, int idTipoPorta) {
        this.equipamentoId = equipamentoId;
        this.nome = nome;
        this.idTipoPorta = idTipoPorta;
    }

    @Override
    public String toString() {
        return "Porta[" + "id=" + id + ", equipamentoId=" + equipamentoId + ", nivelAlarme=" + nivelAlarme + ", nome=" + nome + ", habilitaAlarme=" + habilitaAlarme + ", acionada=" + acionada + ", unidade=" + unidade + ", limAnIn=" + limAnIn + ", limAnSu=" + limAnSu + ", intervaloLeitura=" + intervaloLeitura + ", oid=" + oid + ", alterar=" + alterar + ", emailRelatorio=" + emailRelatorio + ", img=" + img + ", alterouStatus=" + alterouStatus + ", sms=" + sms + ", tipoAlarme=" + tipoAlarme + ", tempoAlarme=" + tempoAlarme + ", emailAlarme=" + emailAlarme + ", minGrafico=" + minGrafico + ", maxGrafico=" + maxGrafico + ", habilitada=" + habilitada + ", reconheceAlarme=" + reconheceAlarme + ", filtro=" + filtro + ", idTipoPorta=" + idTipoPorta + ", constante=" + constante + ", offset=" + offset + ", numeroPorta=" + numeroPorta + ", cfgAcionamento=" + cfgAcionamento + ", idCriticidade=" + idCriticidade + ", categoria=" + categoria + ", totalizar=" + totalizar + ']';
    }

    public Porta() {
    }
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public int getNivelAlarme() {
        return nivelAlarme;
    }

    public void setNivelAlarme(int nivelAlarme) {
        this.nivelAlarme = nivelAlarme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHabilitaAlarme() {
        return habilitaAlarme;
    }

    public void setHabilitaAlarme(int habilitaAlarme) {
        this.habilitaAlarme = habilitaAlarme;
    }

    public int getAcionada() {
        return acionada;
    }

    public void setAcionada(int acionada) {
        this.acionada = acionada;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getLimAnIn() {
        return limAnIn;
    }

    public void setLimAnIn(float limAnIn) {
        this.limAnIn = limAnIn;
    }

    public float getLimAnSu() {
        return limAnSu;
    }

    public void setLimAnSu(float limAnSu) {
        this.limAnSu = limAnSu;
    }

    public int getIntervaloLeitura() {
        return intervaloLeitura;
    }

    public void setIntervaloLeitura(int intervaloLeitura) {
        this.intervaloLeitura = intervaloLeitura;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getAlterar() {
        return alterar;
    }

    public void setAlterar(int alterar) {
        this.alterar = alterar;
    }

    public int getEmailRelatorio() {
        return emailRelatorio;
    }

    public void setEmailRelatorio(int emailRelatorio) {
        this.emailRelatorio = emailRelatorio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAlterouStatus() {
        return alterouStatus;
    }

    public void setAlterouStatus(int alterouStatus) {
        this.alterouStatus = alterouStatus;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getTipoAlarme() {
        return tipoAlarme;
    }

    public void setTipoAlarme(int tipoAlarme) {
        this.tipoAlarme = tipoAlarme;
    }

    public String getTempoAlarme() {
        return tempoAlarme;
    }

    public void setTempoAlarme(String tempoAlarme) {
        this.tempoAlarme = tempoAlarme;
    }

    public int getEmailAlarme() {
        return emailAlarme;
    }

    public void setEmailAlarme(int emailAlarme) {
        this.emailAlarme = emailAlarme;
    }

    public float getMinGrafico() {
        return minGrafico;
    }

    public void setMinGrafico(float minGrafico) {
        this.minGrafico = minGrafico;
    }

    public float getMaxGrafico() {
        return maxGrafico;
    }

    public void setMaxGrafico(float maxGrafico) {
        this.maxGrafico = maxGrafico;
    }

    public int getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(int habilitada) {
        this.habilitada = habilitada;
    }

    public int getReconheceAlarme() {
        return reconheceAlarme;
    }

    public void setReconheceAlarme(int reconheceAlarme) {
        this.reconheceAlarme = reconheceAlarme;
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public int getIdTipoPorta() {
        return idTipoPorta;
    }

    public void setIdTipoPorta(int idTipoPorta) {
        this.idTipoPorta = idTipoPorta;
    }

    public float getConstante() {
        return constante;
    }

    public void setConstante(float constante) {
        this.constante = constante;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public int getNumeroPorta() {
        return numeroPorta;
    }

    public void setNumeroPorta(int numeroPorta) {
        this.numeroPorta = numeroPorta;
    }

    public String getCfgAcionamento() {
        return cfgAcionamento;
    }

    public void setCfgAcionamento(String cfgAcionamento) {
        this.cfgAcionamento = cfgAcionamento;
    }

    public int getIdCriticidade() {
        return idCriticidade;
    }

    public void setIdCriticidade(int idCriticidade) {
        this.idCriticidade = idCriticidade;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getTotalizar() {
        return totalizar;
    }

    public void setTotalizar(int totalizar) {
        this.totalizar = totalizar;
    }
   
   
    
}