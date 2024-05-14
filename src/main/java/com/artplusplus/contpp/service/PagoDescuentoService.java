package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.PagoDescuento;

public interface PagoDescuentoService {
    //Create operation
    PagoDescuento save(PagoDescuento pagoDescuento);

    //Read operation
    List<PagoDescuento> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
