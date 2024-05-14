package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.IsrMensual;

public interface IsrMensualService {
    //Create operation
    IsrMensual save(IsrMensual isrMensual);

    //Read operation
    List<IsrMensual> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
