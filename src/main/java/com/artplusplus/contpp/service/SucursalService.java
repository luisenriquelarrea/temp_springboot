package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Sucursal;

public interface SucursalService {
    //Create operation
    Sucursal save(Sucursal sucursal);
    
    //Read operation
    List<Sucursal> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}