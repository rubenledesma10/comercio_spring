
package com.example.integrador_spring.controller;

import com.example.integrador_spring.dto.FechaVentasDTO;
import com.example.integrador_spring.dto.MayorVentaDTO;
import com.example.integrador_spring.dto.VentasProdDTO;
import com.example.integrador_spring.model.Venta;
import com.example.integrador_spring.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    IVentaService ventaServ;
    
    //END POINT CREAR
    @PostMapping("/ventas/crear")
    public String saveVenta (@RequestBody Venta venta){
        ventaServ.saveVenta(venta);
        return "Venta realizada";
    }
    
    //END POINT TRAER TODOS
    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){
        return ventaServ.getVenta();
    }
    
    //END POINT TRAER UNO 
    @GetMapping("/ventas/traer/{codigo_venta}")
    public Venta unaVenta(@PathVariable Long codigo_venta){
        return ventaServ.findVenta(codigo_venta);
    }
    
    //END POINT ELIMINAR
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "Venta eliminada";
    }
    
    //END POINT EDITAR
    @PutMapping("/ventas/editar")
    public Venta editarVenta (@RequestBody Venta ven){
        ventaServ.editVenta(ven);
        return ventaServ.findVenta(ven.getCodigo_venta());
    }
    
    //END POINT LISTA PRODUCTOS DE UNA VENTA
    @GetMapping("/ventas/productos/{codigo_venta}")
    public VentasProdDTO productosVenta(@PathVariable Long codigo_venta){
        return ventaServ.productosVenta(codigo_venta);
    }
    
    //END POINT SUMATORIO MONTO, CANTIDAD TOTAL DE VENTAS Y FECHA DE VENTAS
    @GetMapping("/ventas/{fecha_venta}")
    public FechaVentasDTO fechaVenta(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate fecha_venta){
        return ventaServ.fechaVenta(fecha_venta);
    }
    
    //END POINT VENTA MAYOR MONTO
    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDTO getVentaMayor (){
        return ventaServ.getVentaMayor();
    }
    
}
