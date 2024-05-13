package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Percepcion;

public interface PercepcionService {
    //Create operation
    Percepcion save(Percepcion percepcion);

    //Read operation
    List<Percepcion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
