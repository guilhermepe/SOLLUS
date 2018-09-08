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
    @Column(columnDefinition="char(50)")
    private String nome;
    @Column(columnDefinition="char(50)")
    private String responsavel;
    @Column(columnDefinition="char(80)")
    private String email;
    @Column(columnDefinition="char(18)")
    private String telefone;
    @Column(columnDefinition="tinyint")
    private int habilitado;
    @Column(columnDefinition="char(100)")
    private String img;
    @Column(name="habilitaimg",columnDefinition="tinyint")
    private int habilitaImg;
    @Column(name="visaocontas",columnDefinition="char(50)")
    private String visaoContas;
    @Column(name="logo_topo_esq",columnDefinition="char(100)")
    private String logoTopoEsq;
    @Column(name="logo_topo_dir",columnDefinition="char(100)")
    private String logoTopoDir;
    @Column(name="logo_rodape",columnDefinition="char(100)")
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

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHabilitaImg(int habilitaImg) {
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

    public int getHabilitado() {
        return habilitado;
    }

    public String getImg() {
        return img;
    }

    public int getHabilitaImg() {
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
