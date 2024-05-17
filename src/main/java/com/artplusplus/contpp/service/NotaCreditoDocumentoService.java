package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.NotaCreditoDocumento;

public interface NotaCreditoDocumentoService {
    //Create operation
    NotaCreditoDocumento save(NotaCreditoDocumento notaCreditoDocumento);

    //Read operation
    List<NotaCreditoDocumento> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
