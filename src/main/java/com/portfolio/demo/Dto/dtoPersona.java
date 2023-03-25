
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String posicion;
    
    @NotBlank
    private String ubicacion;
    
    @NotBlank
    private String sobreMi;
    
    private String imagen;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String posicion, String ubicacion, String sobreMi, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.ubicacion = ubicacion;
        this.sobreMi = sobreMi;
        this.imagen = imagen;
    }
    
    
    
}
