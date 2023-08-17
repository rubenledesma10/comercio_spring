
package com.example.integrador_spring.repository;

import com.example.integrador_spring.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository <Venta, Long> {
    
}
