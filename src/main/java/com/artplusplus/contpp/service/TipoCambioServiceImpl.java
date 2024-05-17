package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoCambio;
import com.artplusplus.contpp.repository.TipoCambioRepository;

import java.util.List;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Override
    public TipoCambio save(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public List<TipoCambio> list(){
        return (List<TipoCambio>) tipoCambioRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoCambioRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoCambioRepository.existsById(id);
    }
}
