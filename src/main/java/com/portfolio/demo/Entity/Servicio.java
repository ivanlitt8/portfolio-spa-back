
package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreS;
    private String descripcionS;
    private String imageS;

    public Servicio() {
    }

    public Servicio(String nombreS, String descripcionS, String imageS) {
        this.nombreS = nombreS;
        this.descripcionS = descripcionS;
        this.imageS = imageS;
    }
    
}