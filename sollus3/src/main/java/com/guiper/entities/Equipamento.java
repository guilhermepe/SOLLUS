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
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long contasId;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private String nome;
    private long ip;
    private int habilitado;
    @Column(name = "idlocal")
    private long idLocal;
    @Column(name = "idservidor")
    private long idServidor;
    @Column(name = "emailalarmeeq")
    private String emailAlarmeEq;
    @Column(name = "tempoalarmeeq")
    private int tempoAlarmeEq;
    private String login;
    private String senha;
    private float latitude;
    private float longitude;
    private int excluido;
    private String numeroSerie;
    @Column(name = "alarmesms")
    private int alarmeSms;
    @Column(name = "alarmehabilitado")
    private int alarmeHabilitado;
    @Column(name = "datahoraultimaleitura")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraUltimaLeitura;
    @Column(name = "fotoequipamento")
    private String fotoEquipamento;
    @Column(name = "idmodelo")
    private int idModelo;
    @Column(name = "idprotocolo")
    private int idProtocolo;
    @Column(name = "portatcp")
    private int portaTcp;
    @Column(name = "idstatus")
    private int idStatus;
    @Column(name = "idtipoconexao")
    private int idTipoConexao;
    @Column(name = "timeoutLeitura")
    private int timeOutLeitura;
    @Column(name = "timeoutConexao")
    private int timeOutConexao;
    @Column(name = "intervaloleitura")
    private int intervaloLeitura;
    @Column(name = "numRetentativas")
    private int numRetentivas;
    @Column(name = "dataHora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "dataInstalacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataInstalacao;
    @Column(name = "dataCriacao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "enderecoagente")
    private String enderecoAgente;
    private String descricao;
    @Column(name = "keepalive")
    private int keepAlive;
    @Column(name = "apagarlogs")
    private int apagarLogs;
    @Column(name = "hexfirmware")
    private String hexFirmware;
    @Column(name = "versaofirmware")
    private String versaoFirmware;
    @Column(name = "versaohardware")
    private String versaoHardware;

    @Override
    public String toString() {
        return "Equipamento[" + "id=" + id + ", contasId=" + contasId + ", nome=" + nome + ", ip=" + ip + ", habilitado=" + habilitado + ", idLocal=" + idLocal + ", idServidor=" + idServidor + ", emailAlarmeEq=" + emailAlarmeEq + ", tempoAlarmeEq=" + tempoAlarmeEq + ", login=" + login + ", senha=" + senha + ", latitude=" + latitude + ", longitude=" + longitude + ", excluido=" + excluido + ", numeroserie=" + numeroSerie + ", alarmeSms=" + alarmeSms + ", alarmeHabilitado=" + alarmeHabilitado + ", dataHoraUltimaLeitura=" + dataHoraUltimaLeitura + ", fotoEquipamento=" + fotoEquipamento + ", idModelo=" + idModelo + ", idProtocolo=" + idProtocolo + ", portaTcp=" + portaTcp + ", idStatus=" + idStatus + ", idTipoConexao=" + idTipoConexao + ", timeOutLeitura=" + timeOutLeitura + ", timeOutConexao=" + timeOutConexao + ", intervaloLeitura=" + intervaloLeitura + ", numRetentivas=" + numRetentivas + ", dataHora=" + dataHora + ", dataInstalacao=" + dataInstalacao + ", dataCriacao=" + dataCriacao + ", enderecoAgente=" + enderecoAgente + ", descricao=" + descricao + ", keepAlive=" + keepAlive + ", apagarLogs=" + apagarLogs + ", hexFirmware=" + hexFirmware + ", versaoFirmware=" + versaoFirmware + ", versaoHardware=" + versaoHardware + ']';
    }
    
    //Constructors

    public Equipamento() {
    }

    public Equipamento(String nome) {
        this.nome = nome;
    }
    
    //Ascessors

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContasId() {
        return contasId;
    }

    public void setContasId(long contasId) {
        this.contasId = contasId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIp() {
        return ip;
    }

    public void setIp(long ip) {
        this.ip = ip;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(long idLocal) {
        this.idLocal = idLocal;
    }

    public long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(long idServidor) {
        this.idServidor = idServidor;
    }

    public String getEmailAlarmeEq() {
        return emailAlarmeEq;
    }

    public void setEmailAlarmeEq(String emailAlarmeEq) {
        this.emailAlarmeEq = emailAlarmeEq;
    }

    public int getTempoAlarmeEq() {
        return tempoAlarmeEq;
    }

    public void setTempoAlarmeEq(int tempoAlarmeEq) {
        this.tempoAlarmeEq = tempoAlarmeEq;
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

    public int getExcluido() {
        return excluido;
    }

    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getAlarmeSms() {
        return alarmeSms;
    }

    public void setAlarmeSms(int alarmeSms) {
        this.alarmeSms = alarmeSms;
    }

    public int getAlarmeHabilitado() {
        return alarmeHabilitado;
    }

    public void setAlarmeHabilitado(int alarmeHabilitado) {
        this.alarmeHabilitado = alarmeHabilitado;
    }

    public Date getDataHoraUltimaLeitura() {
        return dataHoraUltimaLeitura;
    }

    public void setDataHoraUltimaLeitura(Date dataHoraUltimaLeitura) {
        this.dataHoraUltimaLeitura = dataHoraUltimaLeitura;
    }

    public String getFotoEquipamento() {
        return fotoEquipamento;
    }

    public void setFotoEquipamento(String fotoEquipamento) {
        this.fotoEquipamento = fotoEquipamento;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdProtocolo() {
        return idProtocolo;
    }

    public void setIdProtocolo(int idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    public int getPortaTcp() {
        return portaTcp;
    }

    public void setPortaTcp(int portaTcp) {
        this.portaTcp = portaTcp;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdTipoConexao() {
        return idTipoConexao;
    }

    public void setIdTipoConexao(int idTipoConexao) {
        this.idTipoConexao = idTipoConexao;
    }

    public int getTimeOutLeitura() {
        return timeOutLeitura;
    }

    public void setTimeOutLeitura(int timeOutLeitura) {
        this.timeOutLeitura = timeOutLeitura;
    }

    public int getTimeOutConexao() {
        return timeOutConexao;
    }

    public void setTimeOutConexao(int timeOutConexao) {
        this.timeOutConexao = timeOutConexao;
    }

    public int getIntervaloLeitura() {
        return intervaloLeitura;
    }

    public void setIntervaloLeitura(int intervaloLeitura) {
        this.intervaloLeitura = intervaloLeitura;
    }

    public int getNumRetentivas() {
        return numRetentivas;
    }

    public void setNumRetentivas(int numRetentivas) {
        this.numRetentivas = numRetentivas;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getEnderecoAgente() {
        return enderecoAgente;
    }

    public void setEnderecoAgente(String enderecoAgente) {
        this.enderecoAgente = enderecoAgente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getApagarLogs() {
        return apagarLogs;
    }

    public void setApagarLogs(int apagarLogs) {
        this.apagarLogs = apagarLogs;
    }

    public String getHexFirmware() {
        return hexFirmware;
    }

    public void setHexFirmware(String hexFirmware) {
        this.hexFirmware = hexFirmware;
    }

    public String getVersaoFirmware() {
        return versaoFirmware;
    }

    public void setVersaoFirmware(String versaoFirmware) {
        this.versaoFirmware = versaoFirmware;
    }

    public String getVersaoHardware() {
        return versaoHardware;
    }

    public void setVersaoHardware(String versaoHardware) {
        this.versaoHardware = versaoHardware;
    }   
    

}