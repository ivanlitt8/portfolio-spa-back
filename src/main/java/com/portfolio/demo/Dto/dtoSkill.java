
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkill {
    
    @NotBlank
    private String nombreSk;
    @NotBlank
    private String typeSk;
    @NotBlank
    private int porcentajeSk;
    
    private String imageSk;

    public dtoSkill() {
    }
    
    public dtoSkill(String nombreSk, String typeSk, int porcentajeSk, String imageSk) {
        this.nombreSk = nombreSk;
        this.typeSk = typeSk;
        this.porcentajeSk = porcentajeSk;
        this.imageSk = imageSk;
    }
  
}
