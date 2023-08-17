
package com.example.integrador_spring.controller;

import com.example.integrador_spring.model.Cliente;
import com.example.integrador_spring.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    IClienteService clienteServ;
    
    //END POINT CREAR
    @PostMapping("/clientes/crear")
    public String saveCliente (@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
        return "Cliente creado";
    }
    //END POINT TRAER TODO
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        return clienteServ.getClientes();
    }
    
    //END POINT TRAER UNO SOLO
    @GetMapping("/clientes/traer/{id_cliente}")
    public Cliente unCliente(@PathVariable Long id_cliente){
        return clienteServ.findCliente(id_cliente);
    }
    
    //END POINT ELIMINAR
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteServ.deleteCliente(id_cliente);
        return "Cliente eliminado";
    }
    
    //END POINT CREAR EDITAR
    @PutMapping("/clientes/editar")
    public Cliente editarCliente (@RequestBody Cliente cli){
        clienteServ.editCliente(cli);
        return clienteServ.findCliente(cli.getId_cliente());
    }
}
