package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Descuento;

public interface DescuentoService {
    //Create operation
    Descuento save(Descuento descuento);

    //Read operation
    List<Descuento> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
