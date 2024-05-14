package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Incidencia;

public interface IncidenciaService {
    //Create operation
    Incidencia save(Incidencia incidencia);

    //Read operation
    List<Incidencia> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
