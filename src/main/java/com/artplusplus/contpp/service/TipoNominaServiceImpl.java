package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoNomina;
import com.artplusplus.contpp.repository.TipoNominaRepository;

import java.util.List;

@Service
public class TipoNominaServiceImpl implements TipoNominaService {
    @Autowired
    private TipoNominaRepository tipoNominaRepository;

    @Override
    public TipoNomina save(TipoNomina tipoNomina) {
        return tipoNominaRepository.save(tipoNomina);
    }

    @Override
    public List<TipoNomina> list(){
        return (List<TipoNomina>) tipoNominaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoNominaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoNominaRepository.existsById(id);
    }
}
