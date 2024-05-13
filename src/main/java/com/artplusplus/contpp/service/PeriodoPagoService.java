package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.PeriodoPago;

public interface PeriodoPagoService {
    //Create operation
    PeriodoPago save(PeriodoPago periodoPago);

    //Read operation
    List<PeriodoPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
