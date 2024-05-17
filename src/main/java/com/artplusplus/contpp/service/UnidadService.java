package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Unidad;

public interface UnidadService {
    //Create operation
    Unidad save(Unidad unidad);

    //Read operation
    List<Unidad> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
