
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoIdioma {
    
    @NotBlank
    private String nombreI;
    
    @NotBlank
    private String nivelI;
    
    @NotBlank
    private String siglasI;

    public dtoIdioma() {
    }

    public dtoIdioma(String nombreI, String nivelI, String siglasI) {
        this.nombreI = nombreI;
        this.nivelI = nivelI;
        this.siglasI = siglasI;
    }
    
    
}
