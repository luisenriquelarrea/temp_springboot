package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Moneda;

public interface MonedaService {
    //Create operation
    Moneda save(Moneda moneda);

    //Read operation
    List<Moneda> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
