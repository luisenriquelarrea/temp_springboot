package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoOperacion;
import com.artplusplus.contpp.repository.TipoOperacionRepository;

import java.util.List;

@Service
public class TipoOperacionServiceImpl implements TipoOperacionService {
    @Autowired
    private TipoOperacionRepository tipoOperacionRepository;

    @Override
    public TipoOperacion save(TipoOperacion tipoOperacion) {
        return tipoOperacionRepository.save(tipoOperacion);
    }

    @Override
    public List<TipoOperacion> list(){
        return (List<TipoOperacion>) tipoOperacionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoOperacionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoOperacionRepository.existsById(id);
    }
}
