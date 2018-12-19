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
@Table(name = "permissoes")
public class Permissoes implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;    
    @Column(name = "reconheceralarme")    
    private int reconhecerAlarme;
    @Column(name = "historicoleituras")
    private int historicoLeituras;
    @Column(name = "historicoconexoes")
    private int historicoConexoes;
    @Column(name = "historicoalarmes")
    private int historicoAlarmes;
    @Column(name = "cadastrarusuario")
    private int cadastrarUsuario;
    @Column(name = "editarusuario")
    private int editarUsuario;
    @Column(name = "excluirusuario")
    private int excluirUsuario;
    @Column(name = "cadastrarconta")
    private int cadastrarConta;
    @Column(name = "excluirconta")
    private int excluirConta;
    @Column(name = "cadastrarEquipamento")
    private int cadastrar_equipamento;
    @Column(name = "editarEquipamento")
    private int editar_equipamento;
    @Column(name = "excluirEquipamento")
    private int excluir_equipamento;
    @Column(name = "envioSms")
    private int envio_sms;
    @Column(name = "acionarSaida")
    private int acionar_saida;
    @Column(name = "habilitarAlarmeEquip")
    private int habilitar_alarme_equip;
    @Column(name = "idequipamentos")
    private int idEquipamentos;
    private int mapa;
    private int mosaico;
    @Column(name = "historicoLeiturasVariasPortas")
    private int historico_leituras_varias_portas;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private long idUsuario;

    public Permissoes() {
    }

    @Override
    public String toString() {
        return "Permissoes[" + "id=" + id + ", reconhecerAlarme=" + reconhecerAlarme + ", historicoLeituras=" + historicoLeituras + ", historicoConexoes=" + historicoConexoes + ", historicoAlarmes=" + historicoAlarmes + ", cadastrarUsuario=" + cadastrarUsuario + ", editarUsuario=" + editarUsuario + ", excluirUsuario=" + excluirUsuario + ", cadastrarConta=" + cadastrarConta + ", excluirConta=" + excluirConta + ", cadastrar_equipamento=" + cadastrar_equipamento + ", editar_equipamento=" + editar_equipamento + ", excluir_equipamento=" + excluir_equipamento + ", envio_sms=" + envio_sms + ", acionar_saida=" + acionar_saida + ", habilitar_alarme_equip=" + habilitar_alarme_equip + ", idEquipamentos=" + idEquipamentos + ", mapa=" + mapa + ", mosaico=" + mosaico + ", historico_leituras_varias_portas=" + historico_leituras_varias_portas + ", idUsuario=" + idUsuario + ']';
    }
    
    

    public Permissoes(int id, int reconhecerAlarme, int historicoLeituras, int historicoConexoes, int historicoAlarmes, int cadastrarUsuario, int editarUsuario, int excluirUsuario, int cadastrarConta, int excluirConta, int cadastrar_equipamento, int editar_equipamento, int excluir_equipamento, int envio_sms, int acionar_saida, int habilitar_alarme_equip, int idEquipamentos, int mapa, int mosaico, int historico_leituras_varias_portas, long idUsuario) {
        this.id = id;
        this.reconhecerAlarme = reconhecerAlarme;
        this.historicoLeituras = historicoLeituras;
        this.historicoConexoes = historicoConexoes;
        this.historicoAlarmes = historicoAlarmes;
        this.cadastrarUsuario = cadastrarUsuario;
        this.editarUsuario = editarUsuario;
        this.excluirUsuario = excluirUsuario;
        this.cadastrarConta = cadastrarConta;
        this.excluirConta = excluirConta;
        this.cadastrar_equipamento = cadastrar_equipamento;
        this.editar_equipamento = editar_equipamento;
        this.excluir_equipamento = excluir_equipamento;
        this.envio_sms = envio_sms;
        this.acionar_saida = acionar_saida;
        this.habilitar_alarme_equip = habilitar_alarme_equip;
        this.idEquipamentos = idEquipamentos;
        this.mapa = mapa;
        this.mosaico = mosaico;
        this.historico_leituras_varias_portas = historico_leituras_varias_portas;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReconhecerAlarme() {
        return reconhecerAlarme;
    }

    public void setReconhecerAlarme(int reconhecerAlarme) {
        this.reconhecerAlarme = reconhecerAlarme;
    }

    public int getHistoricoLeituras() {
        return historicoLeituras;
    }

    public void setHistoricoLeituras(int historicoLeituras) {
        this.historicoLeituras = historicoLeituras;
    }

    public int getHistoricoConexoes() {
        return historicoConexoes;
    }

    public void setHistoricoConexoes(int historicoConexoes) {
        this.historicoConexoes = historicoConexoes;
    }

    public int getHistoricoAlarmes() {
        return historicoAlarmes;
    }

    public void setHistoricoAlarmes(int historicoAlarmes) {
        this.historicoAlarmes = historicoAlarmes;
    }

    public int getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(int cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public int getEditarUsuario() {
        return editarUsuario;
    }

    public void setEditarUsuario(int editarUsuario) {
        this.editarUsuario = editarUsuario;
    }

    public int getExcluirUsuario() {
        return excluirUsuario;
    }

    public void setExcluirUsuario(int excluirUsuario) {
        this.excluirUsuario = excluirUsuario;
    }

    public int getCadastrarConta() {
        return cadastrarConta;
    }

    public void setCadastrarConta(int cadastrarConta) {
        this.cadastrarConta = cadastrarConta;
    }

    public int getExcluirConta() {
        return excluirConta;
    }

    public void setExcluirConta(int excluirConta) {
        this.excluirConta = excluirConta;
    }

    public int getCadastrar_equipamento() {
        return cadastrar_equipamento;
    }

    public void setCadastrar_equipamento(int cadastrar_equipamento) {
        this.cadastrar_equipamento = cadastrar_equipamento;
    }

    public int getEditar_equipamento() {
        return editar_equipamento;
    }

    public void setEditar_equipamento(int editar_equipamento) {
        this.editar_equipamento = editar_equipamento;
    }

    public int getExcluir_equipamento() {
        return excluir_equipamento;
    }

    public void setExcluir_equipamento(int excluir_equipamento) {
        this.excluir_equipamento = excluir_equipamento;
    }

    public int getEnvio_sms() {
        return envio_sms;
    }

    public void setEnvio_sms(int envio_sms) {
        this.envio_sms = envio_sms;
    }

    public int getAcionar_saida() {
        return acionar_saida;
    }

    public void setAcionar_saida(int acionar_saida) {
        this.acionar_saida = acionar_saida;
    }

    public int getHabilitar_alarme_equip() {
        return habilitar_alarme_equip;
    }

    public void setHabilitar_alarme_equip(int habilitar_alarme_equip) {
        this.habilitar_alarme_equip = habilitar_alarme_equip;
    }

    public int getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(int idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public int getMapa() {
        return mapa;
    }

    public void setMapa(int mapa) {
        this.mapa = mapa;
    }

    public int getMosaico() {
        return mosaico;
    }

    public void setMosaico(int mosaico) {
        this.mosaico = mosaico;
    }

    public int getHistorico_leituras_varias_portas() {
        return historico_leituras_varias_portas;
    }

    public void setHistorico_leituras_varias_portas(int historico_leituras_varias_portas) {
        this.historico_leituras_varias_portas = historico_leituras_varias_portas;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

}

