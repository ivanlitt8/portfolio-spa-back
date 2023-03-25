
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Servicio;
import com.portfolio.demo.Repository.RServicio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SServicio {
    
    @Autowired
    RServicio rServicio;
    
    public List<Servicio> list(){
        return rServicio.findAll();
    }
    
    public Optional<Servicio> getOne(int id){
        return rServicio.findById(id);
    }
    
    public Optional<Servicio> getByNombreE(String nombreS){
        return rServicio.findByNombreS(nombreS);
    }
    
    public void save(Servicio servicio){
        rServicio.save(servicio);
    }
    
    public void delete(int id){
        rServicio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rServicio.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return rServicio.existsByNombreS(nombreS);
    }
}