package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoContrato;

public interface TipoContratoService {
    //Create operation
    TipoContrato save(TipoContrato tipoContrato);

    //Read operation
    List<TipoContrato> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
