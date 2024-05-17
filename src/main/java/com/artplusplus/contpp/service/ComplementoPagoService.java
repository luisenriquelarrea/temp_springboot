package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ComplementoPago;

public interface ComplementoPagoService {
    //Create operation
    ComplementoPago save(ComplementoPago complementoPago);

    //Read operation
    List<ComplementoPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
