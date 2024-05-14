package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Recibo;
import com.artplusplus.contpp.repository.ReciboRepository;

import java.util.List;

@Service
public class ReciboServiceImpl implements ReciboService {
    @Autowired
    private ReciboRepository reciboRepository;

    @Override
    public Recibo save(Recibo recibo) {
        return reciboRepository.save(recibo);
    }

    @Override
    public List<Recibo> list(){
        return (List<Recibo>) reciboRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        reciboRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reciboRepository.existsById(id);
    }
}
