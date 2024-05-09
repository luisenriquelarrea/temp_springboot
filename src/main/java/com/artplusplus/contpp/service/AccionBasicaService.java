package com.artplusplus.contpp.service;

import java.util.List;

import com.artplusplus.contpp.model.AccionBasica;

public interface AccionBasicaService {
    //Create operation
    AccionBasica save(AccionBasica accionBasica);
    
    //Read operation
    List<AccionBasica> list();
}