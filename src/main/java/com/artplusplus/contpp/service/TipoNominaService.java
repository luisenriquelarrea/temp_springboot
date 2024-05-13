package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoNomina;

public interface TipoNominaService {
    //Create operation
    TipoNomina save(TipoNomina tipoNomina);

    //Read operation
    List<TipoNomina> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
