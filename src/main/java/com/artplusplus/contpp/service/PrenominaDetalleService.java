package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.PrenominaDetalle;

public interface PrenominaDetalleService {
    //Create operation
    PrenominaDetalle save(PrenominaDetalle prenominaDetalle);

    //Read operation
    List<PrenominaDetalle> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
