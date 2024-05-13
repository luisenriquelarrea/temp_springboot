package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoPercepcion;

public interface TipoPercepcionService {
    //Create operation
    TipoPercepcion save(TipoPercepcion tipoPercepcion);

    //Read operation
    List<TipoPercepcion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
