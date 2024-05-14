package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ReciboDeduccion;
import com.artplusplus.contpp.repository.ReciboDeduccionRepository;

import java.util.List;

@Service
public class ReciboDeduccionServiceImpl implements ReciboDeduccionService {
    @Autowired
    private ReciboDeduccionRepository reciboDeduccionRepository;

    @Override
    public ReciboDeduccion save(ReciboDeduccion reciboDeduccion) {
        return reciboDeduccionRepository.save(reciboDeduccion);
    }

    @Override
    public List<ReciboDeduccion> list(){
        return (List<ReciboDeduccion>) reciboDeduccionRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        reciboDeduccionRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reciboDeduccionRepository.existsById(id);
    }
}
