package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.TipoCambio;

public interface TipoCambioService {
    //Create operation
    TipoCambio save(TipoCambio tipoCambio);

    //Read operation
    List<TipoCambio> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
