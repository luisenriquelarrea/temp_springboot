package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Deduccion;

public interface DeduccionService {
    //Create operation
    Deduccion save(Deduccion deduccion);

    //Read operation
    List<Deduccion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
