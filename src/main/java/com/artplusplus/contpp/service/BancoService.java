package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.Banco;

public interface BancoService {
    //Create operation
    Banco save(Banco banco);

    //Read operation
    List<Banco> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
