package com.guiper.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.guiper.annotations.SAPLineItem;
import com.guiper.annotations.Sap;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author guiper
 */
@Entity
@Table(name = "portastcp")
public class PortasTcp implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int porta;
    @Sap(filterable=true, sortable=true)
    @SAPLineItem
    private int disponivel;

    public PortasTcp(int porta, int disponivel) {
        this.porta = porta;
        this.disponivel = disponivel;
    }

    public PortasTcp() {
    }

    @Override
    public String toString() {
        return "PortasTcp[" + "porta=" + porta + ", disponivel=" + disponivel + ']';
    }
    
    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }
    
    

    
}

