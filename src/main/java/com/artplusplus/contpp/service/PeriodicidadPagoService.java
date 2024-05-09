package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.PeriodicidadPago;

public interface PeriodicidadPagoService {
    //Create operation
    PeriodicidadPago save(PeriodicidadPago periodicidadPago);
    
    //Read operation
    List<PeriodicidadPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}