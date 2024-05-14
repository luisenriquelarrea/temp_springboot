package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Nomina;

public interface NominaService {
    //Create operation
    Nomina save(Nomina nomina);

    //Read operation
    List<Nomina> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
