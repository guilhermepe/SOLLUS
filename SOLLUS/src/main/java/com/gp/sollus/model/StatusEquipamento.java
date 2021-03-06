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
@Table (name="statusequipamento")
public class StatusEquipamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition="tinyint")
    private long id;
    @Column(columnDefinition="CHAR(15)")
    private String status;

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }    
    
}
