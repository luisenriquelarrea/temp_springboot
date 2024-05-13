package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoRecibo;

public interface TipoReciboService {
    //Create operation
    TipoRecibo save(TipoRecibo tipoRecibo);

    //Read operation
    List<TipoRecibo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
