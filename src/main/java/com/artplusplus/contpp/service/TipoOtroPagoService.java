package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoOtroPago;

public interface TipoOtroPagoService {
    //Create operation
    TipoOtroPago save(TipoOtroPago tipoOtroPago);

    //Read operation
    List<TipoOtroPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
