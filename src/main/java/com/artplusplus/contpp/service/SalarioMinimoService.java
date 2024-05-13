package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.SalarioMinimo;

public interface SalarioMinimoService {
    //Create operation
    SalarioMinimo save(SalarioMinimo salarioMinimo);

    //Read operation
    List<SalarioMinimo> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
