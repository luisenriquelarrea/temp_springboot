package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Ejercicio;

public interface EjercicioService {
    //Create operation
    Ejercicio save(Ejercicio ejercicio);

    //Read operation
    List<Ejercicio> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
