package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Mes;
import com.artplusplus.contpp.repository.MesRepository;

import java.util.List;

@Service
public class MesServiceImpl implements MesService {
    @Autowired
    private MesRepository mesRepository;

    @Override
    public Mes save(Mes mes) {
        return mesRepository.save(mes);
    }

    @Override
    public List<Mes> list(){
        return (List<Mes>) mesRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        mesRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return mesRepository.existsById(id);
    }
}
