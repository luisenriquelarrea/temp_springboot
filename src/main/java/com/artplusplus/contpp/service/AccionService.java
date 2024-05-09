package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Accion;

public interface AccionService {
    //Create operation
    Accion save(Accion accion);
    
    //Read operation
    List<Accion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}