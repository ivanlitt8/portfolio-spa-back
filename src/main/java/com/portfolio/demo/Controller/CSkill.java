
package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoSkill;
import com.portfolio.demo.Entity.Servicio;
import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.SSkill;
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
@RequestMapping("skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {
    
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Servicio>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreSk()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sSkill.existsByNombreS(dtoskill.getNombreSk()))
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoskill.getNombreSk(), dtoskill.getTypeSk(),dtoskill.getPorcentajeSk(), dtoskill.getImageSk());
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoSkill dtoskill){
        if(!sSkill.existsById(id))
            return new ResponseEntity( new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreS(dtoskill.getNombreSk()) && sSkill.getByNombreS(dtoskill.getNombreSk()).get().getId() != id)
            return new ResponseEntity( new Mensaje("La skill ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getNombreSk()))
            return new ResponseEntity( new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreSk(dtoskill.getNombreSk());
        skill.setTypeSk(dtoskill.getTypeSk());
        skill.setPorcentajeSk(dtoskill.getPorcentajeSk());
        skill.setImageSk(dtoskill.getImageSk());

        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity( new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sSkill.delete(id);
        
        return new ResponseEntity( new Mensaje("Skill eliminado"), HttpStatus.OK);

    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Servicio> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
}
