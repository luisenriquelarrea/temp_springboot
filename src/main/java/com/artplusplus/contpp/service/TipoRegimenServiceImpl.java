package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoRegimen;
import com.artplusplus.contpp.repository.TipoRegimenRepository;

import java.util.List;

@Service
public class TipoRegimenServiceImpl implements TipoRegimenService {
    @Autowired
    private TipoRegimenRepository tipoRegimenRepository;

    @Override
    public TipoRegimen save(TipoRegimen tipoRegimen) {
        return tipoRegimenRepository.save(tipoRegimen);
    }

    @Override
    public List<TipoRegimen> list(){
        return (List<TipoRegimen>) tipoRegimenRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoRegimenRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoRegimenRepository.existsById(id);
    }
}
