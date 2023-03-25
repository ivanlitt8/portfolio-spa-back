
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Idioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RIdioma extends JpaRepository<Idioma, Integer>{
    public Optional<Idioma> findByNombreI(String nombreI);
    public boolean existsByNombreI(String nombreI);
    
}
