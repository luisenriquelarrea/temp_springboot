package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoRegimen;

public interface TipoRegimenService {
    //Create operation
    TipoRegimen save(TipoRegimen tipoRegimen);

    //Read operation
    List<TipoRegimen> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
