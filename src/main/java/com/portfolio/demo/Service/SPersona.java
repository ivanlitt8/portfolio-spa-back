
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Persona;
import com.portfolio.demo.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    
    @Autowired
    IPersonaRepository rPersona;
    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return rPersona.findByNombre(nombre);
    }
    
    public void save(Persona per){
        rPersona.save(per);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
        return rPersona.existsByNombre(nombre);
    }
    
}
