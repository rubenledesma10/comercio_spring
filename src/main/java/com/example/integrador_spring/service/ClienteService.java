
package com.example.integrador_spring.service;

import com.example.integrador_spring.model.Cliente;
import com.example.integrador_spring.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public void saveCliente(Cliente cli) {
        clienteRepo.save(cli);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return clienteRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void editCliente(Cliente cli) {
        this.saveCliente(cli);
    }
    
}
