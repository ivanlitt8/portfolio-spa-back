
package com.portfolio.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkill {
    
    @NotBlank
    private String nombreSk;
    @NotBlank
    private int porcentajeSk;
    
    private String imageSk;

    public dtoSkill() {
    }
    
    public dtoSkill(String nombreSk, int porcentajeSk, String imageSk) {
        this.nombreSk = nombreSk;
        this.porcentajeSk = porcentajeSk;
        this.imageSk = imageSk;
    }
  
}
