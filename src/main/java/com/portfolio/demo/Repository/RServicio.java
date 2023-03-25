
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Servicio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RServicio extends JpaRepository<Servicio, Integer>{
    public Optional<Servicio> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}