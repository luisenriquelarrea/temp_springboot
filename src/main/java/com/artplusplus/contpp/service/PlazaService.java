package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Plaza;

public interface PlazaService {
    //Create operation
    Plaza save(Plaza plaza);
    
    //Read operation
    List<Plaza> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}