package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ReciboDeduccion;

public interface ReciboDeduccionService {
    //Create operation
    ReciboDeduccion save(ReciboDeduccion reciboDeduccion);

    //Read operation
    List<ReciboDeduccion> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
