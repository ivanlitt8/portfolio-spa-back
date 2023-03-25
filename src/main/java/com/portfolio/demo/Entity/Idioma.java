
package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Idioma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreI;
    private String nivelI;
    private String siglasI;

    public Idioma() {
    }

    public Idioma(String nombreI, String nivelI, String siglasI) {
        this.nombreI = nombreI;
        this.nivelI = nivelI;
        this.siglasI = siglasI;
    }   
    
}
