
package com.example.integrador_spring.service;

import com.example.integrador_spring.model.Producto;
import com.example.integrador_spring.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public void saveProducto(Producto prod) {
        productoRepo.save(prod);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto prod) {
        this.saveProducto(prod);
    }

    @Override
    public List<Producto> faltaSock() {
        
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaFaltaStock = new ArrayList<>();
        
        for (Producto prod : listaProductos){
            if(prod.getCantidad_disponible()<5){
                listaFaltaStock.add(prod);
            }
        }
        return listaFaltaStock;
    }
    
}
