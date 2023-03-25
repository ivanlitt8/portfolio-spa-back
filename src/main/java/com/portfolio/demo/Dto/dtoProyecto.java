
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
     
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    
    private String imageP;
    
    @NotBlank
    private String fechaInicioP;
    
    @NotBlank
    private String enlaceP;
    
    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String imageP, String fechaInicioP, String enlaceP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imageP = imageP;
        this.fechaInicioP = fechaInicioP;
        this.enlaceP = enlaceP;
    }   
    
}
