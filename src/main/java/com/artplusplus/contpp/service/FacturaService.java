package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Factura;

public interface FacturaService {
    //Create operation
    Factura save(Factura factura);

    //Read operation
    List<Factura> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
