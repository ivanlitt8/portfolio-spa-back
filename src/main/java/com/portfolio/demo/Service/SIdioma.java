/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Idioma;
import com.portfolio.demo.Repository.RIdioma;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdioma {
    
    @Autowired
    RIdioma rIdioma;
    
    public List<Idioma> list(){
        return rIdioma.findAll();
    }
    
    public Optional<Idioma> getOne(int id){
        return rIdioma.findById(id);
    }
    
    public Optional<Idioma> getByNombreI(String nombreI){
        return rIdioma.findByNombreI(nombreI);
    }
    
    public void save(Idioma exp){
        rIdioma.save(exp);
    }
    
    public void delete(int id){
        rIdioma.deleteById(id);
    }
    
    public boolean existById(int id){
        return rIdioma.existsById(id);
    }
    
    public boolean existByNombreI(String nombreI){
        return rIdioma.existsByNombreI(nombreI);
    }
    
}
