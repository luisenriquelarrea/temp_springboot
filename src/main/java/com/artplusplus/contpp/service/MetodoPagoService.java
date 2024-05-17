package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.MetodoPago;

public interface MetodoPagoService {
    //Create operation
    MetodoPago save(MetodoPago metodoPago);

    //Read operation
    List<MetodoPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
