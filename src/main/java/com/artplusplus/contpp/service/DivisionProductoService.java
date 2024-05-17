package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.DivisionProducto;

public interface DivisionProductoService {
    //Create operation
    DivisionProducto save(DivisionProducto divisionProducto);

    //Read operation
    List<DivisionProducto> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
