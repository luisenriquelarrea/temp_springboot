package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.FormaPago;
import com.artplusplus.contpp.repository.FormaPagoRepository;

import java.util.List;

@Service
public class FormaPagoServiceImpl implements FormaPagoService {
    @Autowired
    private FormaPagoRepository formaPagoRepository;

    @Override
    public FormaPago save(FormaPago formaPago) {
        return formaPagoRepository.save(formaPago);
    }

    @Override
    public List<FormaPago> list(){
        return (List<FormaPago>) formaPagoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        formaPagoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return formaPagoRepository.existsById(id);
    }
}
