package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Escolaridad;

public interface EscolaridadService {
    //Create operation
    Escolaridad save(Escolaridad escolaridad);

    //Read operation
    List<Escolaridad> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
