package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoOtroPago;
import com.artplusplus.contpp.repository.TipoOtroPagoRepository;

import java.util.List;

@Service
public class TipoOtroPagoServiceImpl implements TipoOtroPagoService {
    @Autowired
    private TipoOtroPagoRepository tipoOtroPagoRepository;

    @Override
    public TipoOtroPago save(TipoOtroPago tipoOtroPago) {
        return tipoOtroPagoRepository.save(tipoOtroPago);
    }

    @Override
    public List<TipoOtroPago> list(){
        return (List<TipoOtroPago>) tipoOtroPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoOtroPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoOtroPagoRepository.existsById(id);
    }
}
