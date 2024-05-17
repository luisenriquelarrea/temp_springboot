package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.NotaCredito;
import com.artplusplus.contpp.repository.NotaCreditoRepository;

import java.util.List;

@Service
public class NotaCreditoServiceImpl implements NotaCreditoService {
    @Autowired
    private NotaCreditoRepository notaCreditoRepository;

    @Override
    public NotaCredito save(NotaCredito notaCredito) {
        return notaCreditoRepository.save(notaCredito);
    }

    @Override
    public List<NotaCredito> list(){
        return (List<NotaCredito>) notaCreditoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        notaCreditoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return notaCreditoRepository.existsById(id);
    }
}
