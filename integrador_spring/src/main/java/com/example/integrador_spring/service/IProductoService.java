
package com.example.integrador_spring.service;

import com.example.integrador_spring.model.Producto;
import java.util.List;

public interface IProductoService {
    
    //crear
    public void saveProducto(Producto prod);
    
    //traer todos
    public List<Producto> getProductos();
    
    //traer traer un solo objeto
    public Producto findProducto(Long codigo_producto);
    
    //eliminar
    public void deleteProducto(Long codigo_producto);
    
    //editar
    public void editProducto(Producto prod);
    
    //traer menor a 5
    public List<Producto> faltaSock();
    
}
