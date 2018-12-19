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
@Table(name = "historicocon")
public class HistoricoConexao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ideq")
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private Long idEquipamento; 
    private int reiniciado;
    @Column(name = "dataHoraconexao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private Date dataHoraConexao;
    @Column(name = "dataHoradesconexao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private Date dataHoraDesconexao;

    public HistoricoConexao() {
    }

    public HistoricoConexao(Long id, Long idEquipamento, int reiniciado, Date dataHoraConexao, Date dataHoraDesconexao) {
        this.id = id;
        this.idEquipamento = idEquipamento;
        this.reiniciado = reiniciado;
        this.dataHoraConexao = dataHoraConexao;
        this.dataHoraDesconexao = dataHoraDesconexao;
    }

    @Override
    public String toString() {
        return "HistoricoConexao[" + "id=" + id + ", idEquipamento=" + idEquipamento + ", reiniciado=" + reiniciado + ", dataHoraConexao=" + dataHoraConexao + ", dataHoraDesconexao=" + dataHoraDesconexao + ']';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public int getReiniciado() {
        return reiniciado;
    }

    public void setReiniciado(int reiniciado) {
        this.reiniciado = reiniciado;
    }

    public Date getDataHoraConexao() {
        return dataHoraConexao;
    }

    public void setDataHoraConexao(Date dataHoraConexao) {
        this.dataHoraConexao = dataHoraConexao;
    }

    public Date getDataHoraDesconexao() {
        return dataHoraDesconexao;
    }

    public void setDataHoraDesconexao(Date dataHoraDesconexao) {
        this.dataHoraDesconexao = dataHoraDesconexao;
    }
    
    
    
}

