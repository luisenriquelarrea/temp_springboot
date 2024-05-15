package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ContratoLaboral;

public interface ContratoLaboralService {
    //Create operation
    ContratoLaboral save(ContratoLaboral contratoLaboral);

    //Read operation
    List<ContratoLaboral> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
