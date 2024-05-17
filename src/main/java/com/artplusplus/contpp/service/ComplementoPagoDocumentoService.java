package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.ComplementoPagoDocumento;

public interface ComplementoPagoDocumentoService {
    //Create operation
    ComplementoPagoDocumento save(ComplementoPagoDocumento complementoPagoDocumento);

    //Read operation
    List<ComplementoPagoDocumento> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
