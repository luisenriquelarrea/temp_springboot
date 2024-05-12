package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Ejercicio;
import com.artplusplus.contpp.repository.EjercicioRepository;

import java.util.List;

@Service
public class EjercicioServiceImpl implements EjercicioService {
    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public Ejercicio save(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public List<Ejercicio> list(){
        return (List<Ejercicio>) ejercicioRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        ejercicioRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return ejercicioRepository.existsById(id);
    }
}
