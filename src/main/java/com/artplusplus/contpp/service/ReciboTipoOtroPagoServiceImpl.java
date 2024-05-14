package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ReciboTipoOtroPago;
import com.artplusplus.contpp.repository.ReciboTipoOtroPagoRepository;

import java.util.List;

@Service
public class ReciboTipoOtroPagoServiceImpl implements ReciboTipoOtroPagoService {
    @Autowired
    private ReciboTipoOtroPagoRepository reciboTipoOtroPagoRepository;

    @Override
    public ReciboTipoOtroPago save(ReciboTipoOtroPago reciboTipoOtroPago) {
        return reciboTipoOtroPagoRepository.save(reciboTipoOtroPago);
    }

    @Override
    public List<ReciboTipoOtroPago> list(){
        return (List<ReciboTipoOtroPago>) reciboTipoOtroPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        reciboTipoOtroPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reciboTipoOtroPagoRepository.existsById(id);
    }
}
