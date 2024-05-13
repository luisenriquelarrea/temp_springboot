package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoPercepcion;
import com.artplusplus.contpp.repository.TipoPercepcionRepository;

import java.util.List;

@Service
public class TipoPercepcionServiceImpl implements TipoPercepcionService {
    @Autowired
    private TipoPercepcionRepository tipoPercepcionRepository;

    @Override
    public TipoPercepcion save(TipoPercepcion tipoPercepcion) {
        return tipoPercepcionRepository.save(tipoPercepcion);
    }

    @Override
    public List<TipoPercepcion> list(){
        return (List<TipoPercepcion>) tipoPercepcionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoPercepcionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoPercepcionRepository.existsById(id);
    }
}
