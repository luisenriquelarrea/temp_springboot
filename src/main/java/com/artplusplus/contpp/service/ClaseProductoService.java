package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ClaseProducto;

public interface ClaseProductoService {
    //Create operation
    ClaseProducto save(ClaseProducto claseProducto);

    //Read operation
    List<ClaseProducto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
