package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoComprobante;
import com.artplusplus.contpp.repository.TipoComprobanteRepository;

import java.util.List;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {
    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Override
    public TipoComprobante save(TipoComprobante tipoComprobante) {
        return tipoComprobanteRepository.save(tipoComprobante);
    }

    @Override
    public List<TipoComprobante> list(){
        return (List<TipoComprobante>) tipoComprobanteRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoComprobanteRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoComprobanteRepository.existsById(id);
    }
}
