package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Grupo;

public interface GrupoService {
    //Create operation
    Grupo save(Grupo grupo);
    
    //Read operation
    List<Grupo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}