package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Uma;
import com.artplusplus.contpp.repository.UmaRepository;

import java.util.List;

@Service
public class UmaServiceImpl implements UmaService {
    @Autowired
    private UmaRepository umaRepository;

    @Override
    public Uma save(Uma uma) {
        return umaRepository.save(uma);
    }

    @Override
    public List<Uma> list(){
        return (List<Uma>) umaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        umaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return umaRepository.existsById(id);
    }
}
