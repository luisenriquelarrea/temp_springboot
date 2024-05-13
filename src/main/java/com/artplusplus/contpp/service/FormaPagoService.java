package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.FormaPago;

public interface FormaPagoService {
    //Create operation
    FormaPago save(FormaPago formaPago);

    //Read operation
    List<FormaPago> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
