package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoRecibo;
import com.artplusplus.contpp.repository.TipoReciboRepository;

import java.util.List;

@Service
public class TipoReciboServiceImpl implements TipoReciboService {
    @Autowired
    private TipoReciboRepository tipoReciboRepository;

    @Override
    public TipoRecibo save(TipoRecibo tipoRecibo) {
        return tipoReciboRepository.save(tipoRecibo);
    }

    @Override
    public List<TipoRecibo> list(){
        return (List<TipoRecibo>) tipoReciboRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoReciboRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoReciboRepository.existsById(id);
    }
}
