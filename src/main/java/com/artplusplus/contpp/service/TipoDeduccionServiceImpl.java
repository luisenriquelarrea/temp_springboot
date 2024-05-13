package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoDeduccion;
import com.artplusplus.contpp.repository.TipoDeduccionRepository;

import java.util.List;

@Service
public class TipoDeduccionServiceImpl implements TipoDeduccionService {
    @Autowired
    private TipoDeduccionRepository tipoDeduccionRepository;

    @Override
    public TipoDeduccion save(TipoDeduccion tipoDeduccion) {
        return tipoDeduccionRepository.save(tipoDeduccion);
    }

    @Override
    public List<TipoDeduccion> list(){
        return (List<TipoDeduccion>) tipoDeduccionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoDeduccionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoDeduccionRepository.existsById(id);
    }
}
