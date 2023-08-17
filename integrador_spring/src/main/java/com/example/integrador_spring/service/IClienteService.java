
package com.example.integrador_spring.service;

import com.example.integrador_spring.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    //crear
    public void saveCliente(Cliente cli);
    
    //traer todos
    public List<Cliente> getClientes();
    
    //traer traer un solo objeto
    public Cliente findCliente(Long id_cliente);
    
    //eliminar
    public void deleteCliente(Long id_cliente);
    
    //editar
    public void editCliente(Cliente cli);
    
}
