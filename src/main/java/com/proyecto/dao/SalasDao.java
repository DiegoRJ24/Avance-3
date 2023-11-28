
package com.proyecto.dao;

import com.proyecto.domain.Salas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalasDao extends JpaRepository<Salas, Long> {
    
}
