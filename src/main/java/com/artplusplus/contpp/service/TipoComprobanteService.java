package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoComprobante;

public interface TipoComprobanteService {
    //Create operation
    TipoComprobante save(TipoComprobante tipoComprobante);

    //Read operation
    List<TipoComprobante> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
