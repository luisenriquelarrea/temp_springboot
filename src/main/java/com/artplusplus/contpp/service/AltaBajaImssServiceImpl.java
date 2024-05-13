package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.AltaBajaImss;
import com.artplusplus.contpp.repository.AltaBajaImssRepository;

import java.util.List;

@Service
public class AltaBajaImssServiceImpl implements AltaBajaImssService {
    @Autowired
    private AltaBajaImssRepository altaBajaImssRepository;

    @Override
    public AltaBajaImss save(AltaBajaImss altaBajaImss) {
        return altaBajaImssRepository.save(altaBajaImss);
    }

    @Override
    public List<AltaBajaImss> list(){
        return (List<AltaBajaImss>) altaBajaImssRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        altaBajaImssRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return altaBajaImssRepository.existsById(id);
    }
}
