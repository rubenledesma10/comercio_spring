package com.example.integrador_spring.service;

import com.example.integrador_spring.dto.FechaVentasDTO;
import com.example.integrador_spring.dto.MayorVentaDTO;
import com.example.integrador_spring.dto.VentasProdDTO;
import com.example.integrador_spring.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    //crear
    public void saveVenta(Venta ven);
    
    //traer todos
    public List<Venta> getVenta();
    
    //traer traer un solo objeto
    public Venta findVenta(Long codigo_venta);
    
    //eliminar
    public void deleteVenta(Long codigo_venta);
    
    //editar
    public void editVenta(Venta curso);
    
    //traer lista productos de una determinada venta
    public VentasProdDTO productosVenta(Long codigo_venta);
    
    //traer sumatorio monto y total de ventas de un determinado dia
    public FechaVentasDTO fechaVenta(LocalDate fecha_venta);
    
    //detalles monto mas alto
    public MayorVentaDTO getVentaMayor();
    
}
