/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoServicio;
import com.portfolio.demo.Entity.Servicio;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.SServicio;
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
@RequestMapping("services")
@CrossOrigin(origins = "http://localhost:4200")
public class CServicio {
    
    @Autowired
    SServicio sServicio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Servicio>> list(){
        List<Servicio> list = sServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoServicio dtoServ){
        if(StringUtils.isBlank(dtoServ.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sServicio.existsByNombreS(dtoServ.getNombreS()))
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        Servicio servicio = new Servicio(dtoServ.getNombreS(), dtoServ.getDescripcionS(), dtoServ.getImageS());
        sServicio.save(servicio);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoServicio dtoServ){
        if(!sServicio.existsById(id))
            return new ResponseEntity( new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(sServicio.existsByNombreS(dtoServ.getNombreS()) && sServicio.getByNombreE(dtoServ.getNombreS()).get().getId() != id)
            return new ResponseEntity( new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoServ.getNombreS()))
            return new ResponseEntity( new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Servicio servicio = sServicio.getOne(id).get();
        servicio.setNombreS(dtoServ.getNombreS());
        servicio.setDescripcionS(dtoServ.getDescripcionS());
        servicio.setImageS(dtoServ.getImageS());

        
        sServicio.save(servicio);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sServicio.existsById(id))
            return new ResponseEntity( new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        sServicio.delete(id);
        
        return new ResponseEntity( new Mensaje("Experiencia eliminado"), HttpStatus.OK);

    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Servicio> getById(@PathVariable("id") int id){
        if(!sServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Servicio servicio = sServicio.getOne(id).get();
        return new ResponseEntity(servicio, HttpStatus.OK);
    }  
    
    
}
