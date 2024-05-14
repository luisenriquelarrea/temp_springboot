package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ReciboTipoOtroPago;

public interface ReciboTipoOtroPagoService {
    //Create operation
    ReciboTipoOtroPago save(ReciboTipoOtroPago reciboTipoOtroPago);

    //Read operation
    List<ReciboTipoOtroPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
