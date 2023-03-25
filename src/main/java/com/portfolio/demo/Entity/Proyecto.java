/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreP;
    private String descripcionP;
    private String imageP;
    private String fechaInicioP;
    private String enlaceP;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String imageP, String fechaInicioP, String enlaceP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imageP = imageP;
        this.fechaInicioP = fechaInicioP;
        this.enlaceP = enlaceP;
    }

    
    
}
