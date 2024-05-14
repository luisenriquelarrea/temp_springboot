package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.IsrMensual;
import com.artplusplus.contpp.repository.IsrMensualRepository;

import java.util.List;

@Service
public class IsrMensualServiceImpl implements IsrMensualService {
    @Autowired
    private IsrMensualRepository isrMensualRepository;

    @Override
    public IsrMensual save(IsrMensual isrMensual) {
        return isrMensualRepository.save(isrMensual);
    }

    @Override
    public List<IsrMensual> list(){
        return (List<IsrMensual>) isrMensualRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        isrMensualRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return isrMensualRepository.existsById(id);
    }
}
