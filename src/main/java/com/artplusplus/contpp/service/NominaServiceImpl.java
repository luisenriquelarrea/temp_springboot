package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Nomina;
import com.artplusplus.contpp.repository.NominaRepository;

import java.util.List;

@Service
public class NominaServiceImpl implements NominaService {
    @Autowired
    private NominaRepository nominaRepository;

    @Override
    public Nomina save(Nomina nomina) {
        return nominaRepository.save(nomina);
    }

    @Override
    public List<Nomina> list(){
        return (List<Nomina>) nominaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        nominaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return nominaRepository.existsById(id);
    }
}
