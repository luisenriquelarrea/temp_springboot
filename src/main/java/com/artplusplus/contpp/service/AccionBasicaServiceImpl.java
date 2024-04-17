package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.AccionBasica;
import com.artplusplus.contpp.repository.AccionBasicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionBasicaServiceImpl implements AccionBasicaService {
    @Autowired private AccionBasicaRepository accionBasicaRepository;

    @Override
    public List<AccionBasica> list(){
        return (List<AccionBasica>) accionBasicaRepository.findAll();
    }
}
