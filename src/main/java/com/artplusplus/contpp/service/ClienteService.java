package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Cliente;

public interface ClienteService {
    //Create operation
    Cliente save(Cliente cliente);

    //Read operation
    List<Cliente> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
