package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoIncidencia;

public interface TipoIncidenciaService {
    //Create operation
    TipoIncidencia save(TipoIncidencia tipoIncidencia);

    //Read operation
    List<TipoIncidencia> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
