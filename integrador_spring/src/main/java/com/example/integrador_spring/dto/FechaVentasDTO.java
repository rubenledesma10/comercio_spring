
package com.example.integrador_spring.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FechaVentasDTO {
    
    private LocalDate fecha_venta;
    private Long total_ventas;
    private Double sumatoria_monto;

    public FechaVentasDTO() {
    }

    public FechaVentasDTO(LocalDate fecha_venta, Long total_ventas, Double sumatoria_monto) {
        this.fecha_venta = fecha_venta;
        this.total_ventas = total_ventas;
        this.sumatoria_monto = sumatoria_monto;
    }
    
}
