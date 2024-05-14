package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Recibo;

public interface ReciboService {
    //Create operation
    Recibo save(Recibo recibo);

    //Read operation
    List<Recibo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
