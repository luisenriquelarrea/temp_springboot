package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ReciboPercepcion;

public interface ReciboPercepcionService {
    //Create operation
    ReciboPercepcion save(ReciboPercepcion reciboPercepcion);

    //Read operation
    List<ReciboPercepcion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
