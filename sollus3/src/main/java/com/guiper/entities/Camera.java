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
@Table(name = "camera")
public class Camera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Sap(filterable = true, sortable = true)
    @SAPLineItem
    private String nome;
    private String endereco;
    @Column(name = "contas")
    private Long contaId;

    public Camera() {
    }

    public Camera(long id, String nome, String endereco, Long contaId) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contaId = contaId;
    }

    @Override
    public String toString() {
        return "Camera[" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", contaId=" + contaId + ']';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }
}
