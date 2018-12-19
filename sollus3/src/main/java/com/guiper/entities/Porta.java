
package com.guiper.entities;

import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
   @Column(name = "idportas")
   private long id;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   @Column(name = "EquipamentoId")
   private long equipamentoId;
   @Column(name = "nivelalarme")
   private boolean nivelAlarme;
   @Sap(filterable=true, sortable=true)
   @SAPLineItem
   private String nome;
   @Column(name = "habilitaalarme")
   private boolean habilitaAlarme;
   private boolean acionada;
   private String unidade;
   @Column(name = "limanin")
   private float limAnIn;
   @Column(name = "limansu")
   private float limAnSu;
   @Column(name = "intervaloleitura")
   private int intervaloLeitura;
   private String oid;
   private boolean alterar;
   @Column(name = "emailrelatorio")
   private boolean emailRelatorio;
   private String img;
   @Column(name = "alteroustatus")
   private boolean alterouStatus;
   private boolean sms;
   @Column(name = "tipoalarme")
   private int tipoAlarme;
   @Column(name = "tempoalarme")
   private String tempoAlarme;
   @Column(name = "emailalarme")
   private boolean emailAlarme;
   @Column(name = "mingrafico")
   private float minGrafico;
   @Column(name = "maxgrafico")
   private float maxGrafico;
   private boolean habilitada;
   @Column(name = "reconhecealarme")
   private boolean reconheceAlarme;
   private boolean filtro;
   @Column(name = "idtipoporta")
   private int idTipoPorta;
   private float constante;
   private float offset;
   private int numeroPorta;
   @Column(name = "cfgacionamento")
   private String cfgAcionamento;
   @Column(name = "idcriticidade")
   private int idCriticidade;
   private int categoria;
   private int totalizar;
   @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name="portasIdportas")
   private List<Leitura> leituras  = new ArrayList<>();

    public Porta(long equipamentoId, String nome, int idTipoPorta) {
        this.equipamentoId = equipamentoId;
        this.nome = nome;
        this.idTipoPorta = idTipoPorta;
    }

    public List<Leitura> getLeituras() {
        return leituras;
    }

    public int getTipoAlarme() {
        return tipoAlarme;
    }

    public void setTipoAlarme(int tipoAlarme) {
        this.tipoAlarme = tipoAlarme;
    }  
    

    public void setLeituras(List<Leitura> leituras) {
        this.leituras = leituras;
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

    public boolean isNivelAlarme() {
        return nivelAlarme;
    }

    public void setNivelAlarme(boolean nivelAlarme) {
        this.nivelAlarme = nivelAlarme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHabilitaAlarme() {
        return habilitaAlarme;
    }

    public void setHabilitaAlarme(boolean habilitaAlarme) {
        this.habilitaAlarme = habilitaAlarme;
    }

    public boolean isAcionada() {
        return acionada;
    }

    public void setAcionada(boolean acionada) {
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

    public boolean isAlterar() {
        return alterar;
    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isEmailRelatorio() {
        return emailRelatorio;
    }

    public void setEmailRelatorio(boolean emailRelatorio) {
        this.emailRelatorio = emailRelatorio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isAlterouStatus() {
        return alterouStatus;
    }

    public void setAlterouStatus(boolean alterouStatus) {
        this.alterouStatus = alterouStatus;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }    

    public String getTempoAlarme() {
        return tempoAlarme;
    }

    public void setTempoAlarme(String tempoAlarme) {
        this.tempoAlarme = tempoAlarme;
    }

    public boolean isEmailAlarme() {
        return emailAlarme;
    }

    public void setEmailAlarme(boolean emailAlarme) {
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

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public boolean isReconheceAlarme() {
        return reconheceAlarme;
    }

    public void setReconheceAlarme(boolean reconheceAlarme) {
        this.reconheceAlarme = reconheceAlarme;
    }

    public boolean isFiltro() {
        return filtro;
    }

    public void setFiltro(boolean filtro) {
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
