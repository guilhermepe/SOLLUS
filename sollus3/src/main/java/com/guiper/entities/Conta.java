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
@Table(name = "contas")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @Sap(filterable=true, sortable=true)
    @SAPLineItem   
    private String nome;
    private String responsavel;
    private String email;
    private String telefone;
    private String img;
    @Column(name = "visaocontas")
    private String visaoContas;
    private String logoTopoEsq;
    private String logoTopoDir;
    private String logoRodape;    
    private int habilitado;
    @Column(name = "habilitaimg")
    private int habilitaImg;

    public Conta() {
    }

    public Conta(long id, String nome, String responsavel, String email, String telefone, String img, String visaoContas, String logoTopoEsq, String logoTopoDir, String logoRodape, int habilitado, int habilitaImg) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.email = email;
        this.telefone = telefone;
        this.img = img;
        this.visaoContas = visaoContas;
        this.logoTopoEsq = logoTopoEsq;
        this.logoTopoDir = logoTopoDir;
        this.logoRodape = logoRodape;
        this.habilitado = habilitado;
        this.habilitaImg = habilitaImg;
    }

    @Override
    public String toString() {
        return "Conta[" + "id=" + id + ", nome=" + nome + ", responsavel=" + responsavel + ", email=" + email + ", telefone=" + telefone + ", img=" + img + ", visaoContas=" + visaoContas + ", logoTopoEsq=" + logoTopoEsq + ", logoTopoDir=" + logoTopoDir + ", logoRodape=" + logoRodape + ", habilitado=" + habilitado + ", habilitaImg=" + habilitaImg + ']';
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVisaoContas() {
        return visaoContas;
    }

    public void setVisaoContas(String visaoContas) {
        this.visaoContas = visaoContas;
    }

    public String getLogoTopoEsq() {
        return logoTopoEsq;
    }

    public void setLogoTopoEsq(String logoTopoEsq) {
        this.logoTopoEsq = logoTopoEsq;
    }

    public String getLogoTopoDir() {
        return logoTopoDir;
    }

    public void setLogoTopoDir(String logoTopoDir) {
        this.logoTopoDir = logoTopoDir;
    }

    public String getLogoRodape() {
        return logoRodape;
    }

    public void setLogoRodape(String logoRodape) {
        this.logoRodape = logoRodape;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    public int getHabilitaImg() {
        return habilitaImg;
    }

    public void setHabilitaImg(int habilitaImg) {
        this.habilitaImg = habilitaImg;
    }
    
    
    
   
}

