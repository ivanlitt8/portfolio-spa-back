
package com.portfolio.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no comple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no comple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no comple con la longitud")
    private String posicion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no comple con la longitud")
    private String ubicacion;
    
    @NotNull
    @Size(min = 20, max = 255, message = "no comple con la longitud")
    private String sobreMi;
    
    @Size(min = 1, max = 50, message = "no comple con la longitud")
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String posicion, String ubicacion, String sobreMi, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.ubicacion = ubicacion;
        this.sobreMi = sobreMi;
        this.img = img;
    }
    
    
    
}
