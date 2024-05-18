package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.SerieCfdi;
import com.artplusplus.contpp.repository.SerieCfdiRepository;

import java.util.List;

@Service
public class SerieCfdiServiceImpl implements SerieCfdiService {
    @Autowired
    private SerieCfdiRepository serieCfdiRepository;

    @Override
    public SerieCfdi save(SerieCfdi serieCfdi) {
        return serieCfdiRepository.save(serieCfdi);
    }

    @Override
    public List<SerieCfdi> list(){
        return (List<SerieCfdi>) serieCfdiRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        serieCfdiRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return serieCfdiRepository.existsById(id);
    }
}
