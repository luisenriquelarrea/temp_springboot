package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Concepto;

public interface ConceptoService {
    //Create operation
    Concepto save(Concepto concepto);

    //Read operation
    List<Concepto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
