package com.example.integrador_spring.dto;

import com.example.integrador_spring.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class VentasProdDTO {
    
    private Long codigo_venta;
    private List<Producto> listaProductosVenta;

    public VentasProdDTO() {
    }

    public VentasProdDTO(Long codigo_venta, List<Producto> listaProductosVenta) {
        this.codigo_venta = codigo_venta;
        this.listaProductosVenta = listaProductosVenta;
    }
    
}
