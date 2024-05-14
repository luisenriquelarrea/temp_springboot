package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Incidencia;
import com.artplusplus.contpp.repository.IncidenciaRepository;

import java.util.List;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Override
    public Incidencia save(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public List<Incidencia> list(){
        return (List<Incidencia>) incidenciaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        incidenciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return incidenciaRepository.existsById(id);
    }
}
