package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Bono;

public interface BonoService {
    //Create operation
    Bono save(Bono bono);

    //Read operation
    List<Bono> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
