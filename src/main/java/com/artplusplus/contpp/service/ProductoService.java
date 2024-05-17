package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Producto;

public interface ProductoService {
    //Create operation
    Producto save(Producto producto);

    //Read operation
    List<Producto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
