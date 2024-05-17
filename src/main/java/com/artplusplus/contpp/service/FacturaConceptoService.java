package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.FacturaConcepto;

public interface FacturaConceptoService {
    //Create operation
    FacturaConcepto save(FacturaConcepto facturaConcepto);

    //Read operation
    List<FacturaConcepto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
