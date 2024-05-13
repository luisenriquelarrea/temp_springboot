package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoDeduccion;

public interface TipoDeduccionService {
    //Create operation
    TipoDeduccion save(TipoDeduccion tipoDeduccion);

    //Read operation
    List<TipoDeduccion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
