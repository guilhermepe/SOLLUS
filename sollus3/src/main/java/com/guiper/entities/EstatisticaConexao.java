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
@Table(name = "estatisticaconexao")
public class EstatisticaConexao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ideq")
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private Long idEquipamento;    
    @Column(name = "leiturasesperadas")
    private int leiturasEsperadas;
    @Column(name = "leiturasefetuadas")
    private int leiturasEfetuadas;
    private int retentivas;    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private Date dataEstatistica;

    public EstatisticaConexao() {
    }

    public EstatisticaConexao(Long id, Long idEquipamento, int leiturasEsperadas, int leiturasEfetuadas, int retentivas, Date dataEstatistica) {
        this.id = id;
        this.idEquipamento = idEquipamento;
        this.leiturasEsperadas = leiturasEsperadas;
        this.leiturasEfetuadas = leiturasEfetuadas;
        this.retentivas = retentivas;
        this.dataEstatistica = dataEstatistica;
    }

    @Override
    public String toString() {
        return "EstatisticaConexao[" + "id=" + id + ", idEquipamento=" + idEquipamento + ", leiturasEsperadas=" + leiturasEsperadas + ", leiturasEfetuadas=" + leiturasEfetuadas + ", retentivas=" + retentivas + ", dataEstatistica=" + dataEstatistica + ']';
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

    public int getLeiturasEsperadas() {
        return leiturasEsperadas;
    }

    public void setLeiturasEsperadas(int leiturasEsperadas) {
        this.leiturasEsperadas = leiturasEsperadas;
    }

    public int getLeiturasEfetuadas() {
        return leiturasEfetuadas;
    }

    public void setLeiturasEfetuadas(int leiturasEfetuadas) {
        this.leiturasEfetuadas = leiturasEfetuadas;
    }

    public int getRetentivas() {
        return retentivas;
    }

    public void setRetentivas(int retentivas) {
        this.retentivas = retentivas;
    }

    public Date getDataEstatistica() {
        return dataEstatistica;
    }

    public void setDataEstatistica(Date dataEstatistica) {
        this.dataEstatistica = dataEstatistica;
    }
    

}

