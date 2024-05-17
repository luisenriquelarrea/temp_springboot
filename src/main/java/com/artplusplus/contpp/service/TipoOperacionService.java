package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoOperacion;

public interface TipoOperacionService {
    //Create operation
    TipoOperacion save(TipoOperacion tipoOperacion);

    //Read operation
    List<TipoOperacion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
