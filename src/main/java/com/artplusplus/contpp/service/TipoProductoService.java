package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoProducto;

public interface TipoProductoService {
    //Create operation
    TipoProducto save(TipoProducto tipoProducto);

    //Read operation
    List<TipoProducto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
