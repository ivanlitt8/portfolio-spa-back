
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Repository.RSkill;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    
    @Autowired
    RSkill rSkill;
    
    public List<Skill> list(){
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombreS(String nombreSk){
        return rSkill.findByNombreSk(nombreSk);
    }
    
    public void save(Skill skill){
        rSkill.save(skill);
    }
    
    public void delete(int id){
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreSk){
        return rSkill.existsByNombreSk(nombreSk);
    }
    
}
