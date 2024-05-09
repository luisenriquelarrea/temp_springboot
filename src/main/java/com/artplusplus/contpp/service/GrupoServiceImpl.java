package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Grupo;
import com.artplusplus.contpp.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
    @Autowired 
    private GrupoRepository grupoRepository;

    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public List<Grupo> list(){
        return (List<Grupo>) grupoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        grupoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return grupoRepository.existsById(id);
    }
}
