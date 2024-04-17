package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Accion;
import com.artplusplus.contpp.repository.AccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionServiceImpl implements AccionService {
    @Autowired private AccionRepository accionRepository;

    @Override
    public List<Accion> list(){
        return (List<Accion>) accionRepository.findAll();
    }
}
