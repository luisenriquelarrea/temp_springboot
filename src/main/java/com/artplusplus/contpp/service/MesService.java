package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Mes;

public interface MesService {
    //Create operation
    Mes save(Mes mes);

    //Read operation
    List<Mes> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
