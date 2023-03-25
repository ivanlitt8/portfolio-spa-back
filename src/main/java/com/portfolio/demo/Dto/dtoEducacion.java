
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion { 
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String fechaInicioE;
    
    private String fechaFinE;
    private String imagenE;

    

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String fechaInicioE, String fechaFinE, String imagenE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinE = fechaFinE;
        this.imagenE = imagenE;
    }    
    
}