
package com.example.integrador_spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {
    
    private Long codigo_venta;
    private Double total_venta;
    private int cant_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, Double total_venta, int cant_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total_venta = total_venta;
        this.cant_productos = cant_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
    
}
