package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.PagoBono;

public interface PagoBonoService {
    //Create operation
    PagoBono save(PagoBono pagoBono);

    //Read operation
    List<PagoBono> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
