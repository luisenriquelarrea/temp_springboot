package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Prenomina;

public interface PrenominaService {
    //Create operation
    Prenomina save(Prenomina prenomina);

    //Read operation
    List<Prenomina> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
