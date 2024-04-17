package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired private GrupoRepository grupoRepository;

    @Override
    public List<Grupo> list(){
        return (List<Grupo>) grupoRepository.findAll();
    }
}
