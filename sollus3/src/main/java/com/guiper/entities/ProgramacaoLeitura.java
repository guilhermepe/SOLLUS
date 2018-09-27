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
@Table(name = "programacaoleitura")
public class ProgramacaoLeitura implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;    
    @Column(name = "idequip")
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private long idEquipamento;
    @Column(name = "valorInicio")
    private int valorInicio;
    @Column(name = "valorRetorno")
    private int valorRetorno;
    @Column(name = "diasProgramados")
    private int diasProgramados;
    @Column(name = "dataHoraInicio")
    private String dataHoraInicio;
    private int enviado;

    public ProgramacaoLeitura() {
    }

    public ProgramacaoLeitura(long id, long idEquipamento, int valorInicio, int valorRetorno, int diasProgramados, String dataHoraInicio, int enviado) {
        this.id = id;
        this.idEquipamento = idEquipamento;
        this.valorInicio = valorInicio;
        this.valorRetorno = valorRetorno;
        this.diasProgramados = diasProgramados;
        this.dataHoraInicio = dataHoraInicio;
        this.enviado = enviado;
    }

    @Override
    public String toString() {
        return "ProgramacaoLeitura[" + "id=" + id + ", idEquipamento=" + idEquipamento + ", valorInicio=" + valorInicio + ", valorRetorno=" + valorRetorno + ", diasProgramados=" + diasProgramados + ", dataHoraInicio=" + dataHoraInicio + ", enviado=" + enviado + ']';
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

    public int getValorInicio() {
        return valorInicio;
    }

    public void setValorInicio(int valorInicio) {
        this.valorInicio = valorInicio;
    }

    public int getValorRetorno() {
        return valorRetorno;
    }

    public void setValorRetorno(int valorRetorno) {
        this.valorRetorno = valorRetorno;
    }

    public int getDiasProgramados() {
        return diasProgramados;
    }

    public void setDiasProgramados(int diasProgramados) {
        this.diasProgramados = diasProgramados;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public int getEnviado() {
        return enviado;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }
    
    
    
}

