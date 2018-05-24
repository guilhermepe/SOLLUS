/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.sollus.model;

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
@Table (name="contas")
public class Conta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String responsavel;
    private String email;
    private String telefone;
    private String habilitado;
    private String img;
    private String habilitaImg;
    private String visaoContas;
    @Column(name="logo_topo_esq")
    private String logoTopoEsq;
    @Column(name="logo_topo_dir")
    private String logoTopoDir;
    @Column(name="logo_rodape")
    private String logoRodape;
    
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHabilitaImg(String habilitaImg) {
        this.habilitaImg = habilitaImg;
    }

    public void setVisaoContas(String visaoContas) {
        this.visaoContas = visaoContas;
    }

    public void setLogoTopoEsq(String logoTopoEsq) {
        this.logoTopoEsq = logoTopoEsq;
    }

    public void setLogoTopoDir(String logoTopoDir) {
        this.logoTopoDir = logoTopoDir;
    }

    public void setLogoRodape(String logoRodape) {
        this.logoRodape = logoRodape;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public String getImg() {
        return img;
    }

    public String getHabilitaImg() {
        return habilitaImg;
    }

    public String getVisaoContas() {
        return visaoContas;
    }

    public String getLogoTopoEsq() {
        return logoTopoEsq;
    }

    public String getLogoTopoDir() {
        return logoTopoDir;
    }

    public String getLogoRodape() {
        return logoRodape;
    }
    
}
