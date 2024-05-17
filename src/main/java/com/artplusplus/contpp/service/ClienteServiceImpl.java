package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Cliente;
import com.artplusplus.contpp.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> list(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }
}
