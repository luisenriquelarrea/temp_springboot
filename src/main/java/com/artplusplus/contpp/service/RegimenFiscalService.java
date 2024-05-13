package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.RegimenFiscal;

public interface RegimenFiscalService {
    //Create operation
    RegimenFiscal save(RegimenFiscal regimenFiscal);

    //Read operation
    List<RegimenFiscal> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);
}
