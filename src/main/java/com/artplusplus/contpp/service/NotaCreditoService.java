package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.NotaCredito;

public interface NotaCreditoService {
    //Create operation
    NotaCredito save(NotaCredito notaCredito);

    //Read operation
    List<NotaCredito> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
