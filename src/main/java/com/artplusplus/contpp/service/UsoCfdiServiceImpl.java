package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.UsoCfdi;
import com.artplusplus.contpp.repository.UsoCfdiRepository;

import java.util.List;

@Service
public class UsoCfdiServiceImpl implements UsoCfdiService {
    @Autowired
    private UsoCfdiRepository usoCfdiRepository;

    @Override
    public UsoCfdi save(UsoCfdi usoCfdi) {
        return usoCfdiRepository.save(usoCfdi);
    }

    @Override
    public List<UsoCfdi> list(){
        return (List<UsoCfdi>) usoCfdiRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        usoCfdiRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usoCfdiRepository.existsById(id);
    }
}
