package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.IsrSemanal;
import com.artplusplus.contpp.repository.IsrSemanalRepository;

import java.util.List;

@Service
public class IsrSemanalServiceImpl implements IsrSemanalService {
    @Autowired
    private IsrSemanalRepository isrSemanalRepository;

    @Override
    public IsrSemanal save(IsrSemanal isrSemanal) {
        return isrSemanalRepository.save(isrSemanal);
    }

    @Override
    public List<IsrSemanal> list(){
        return (List<IsrSemanal>) isrSemanalRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        isrSemanalRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return isrSemanalRepository.existsById(id);
    }
}
