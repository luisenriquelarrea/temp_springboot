package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Puesto;

public interface PuestoService {
    //Create operation
    Puesto save(Puesto puesto);
    
    //Read operation
    List<Puesto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}