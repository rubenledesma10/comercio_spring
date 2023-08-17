
package com.example.integrador_spring.controller;

import com.example.integrador_spring.model.Producto;
import com.example.integrador_spring.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService productoServ;
    
    //END POINT CREAR
    @PostMapping("/productos/crear")
    public String saveCliente (@RequestBody Producto producto){
        productoServ.saveProducto(producto);
        return "Producto creado";
    }
    
    //END POINT TRAER TODOS
    @GetMapping("/productos/traer")
    public List<Producto> getProductos(){
        return productoServ.getProductos();
    }
    
    //END POINT TRAER UNO 
    @GetMapping("/productos/traer/{codigo_producto}")
    public Producto unCliente(@PathVariable Long codigo_producto){
        return productoServ.findProducto(codigo_producto);
    }
    
    //END POINT ELIMINAR
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productoServ.deleteProducto(codigo_producto);
        return "Producto eliminado";
    }
    
    //END POINT EDITAR
    @PutMapping("/productos/editar")
    public Producto editarProducto (@RequestBody Producto prod){
        productoServ.editProducto(prod);
        return productoServ.findProducto(prod.getCodigo_producto());
    }
    
    //END POINT FALTANTE STOCK
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaSock(){
        return productoServ.faltaSock();
    }
}
