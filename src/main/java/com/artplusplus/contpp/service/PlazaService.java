package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Plaza;

public interface PlazaService {
    //Cread operation
    Plaza savePlaza(Plaza plaza);

    //Read operation
    List<Plaza> listPlaza();

    //Delete operation
    void deletePlaza(Long id);

    //Get by id operation
    boolean getById(Long id);

    //Get Plaza entity by id
    Plaza plazaById(Long id);
}