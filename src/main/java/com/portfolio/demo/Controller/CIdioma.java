
package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoIdioma;
import com.portfolio.demo.Entity.Idioma;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.SIdioma;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("idiomas")
@CrossOrigin(origins = "http://localhost:4200")
public class CIdioma {
    
    @Autowired
    SIdioma sIdioma;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Idioma>> list(){
        List<Idioma> list = sIdioma.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoIdioma dtoidioma){
        if(StringUtils.isBlank(dtoidioma.getNombreI())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sIdioma.existByNombreI(dtoidioma.getNombreI())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = new Idioma(dtoidioma.getNombreI(), dtoidioma.getNivelI(), dtoidioma.getSiglasI());
        sIdioma.save(idioma);
        return new ResponseEntity(new Mensaje("Idioma creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoIdioma dtoidioma){
        if(!sIdioma.existById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        if(sIdioma.existByNombreI(dtoidioma.getNombreI()) && sIdioma.getByNombreI(dtoidioma.getNombreI()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoidioma.getNombreI())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = sIdioma.getOne(id).get();
        
        idioma.setNombreI(dtoidioma.getNombreI());
        idioma.setNivelI(dtoidioma.getNivelI());
        idioma.setSiglasI(dtoidioma.getSiglasI());
        
        sIdioma.save(idioma);
        
        return new ResponseEntity(new Mensaje("Idioma actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sIdioma.existById(id)){
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        sIdioma.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado"), HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id")int id){
        if(!sIdioma.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = sIdioma.getOne(id).get();
        return new ResponseEntity(idioma, HttpStatus.OK);
    }
    
    
}
