package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoJornada;

public interface TipoJornadaService {
    //Create operation
    TipoJornada save(TipoJornada tipoJornada);

    //Read operation
    List<TipoJornada> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
