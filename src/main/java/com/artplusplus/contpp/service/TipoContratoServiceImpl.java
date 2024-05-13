package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoContrato;
import com.artplusplus.contpp.repository.TipoContratoRepository;

import java.util.List;

@Service
public class TipoContratoServiceImpl implements TipoContratoService {
    @Autowired
    private TipoContratoRepository tipoContratoRepository;

    @Override
    public TipoContrato save(TipoContrato tipoContrato) {
        return tipoContratoRepository.save(tipoContrato);
    }

    @Override
    public List<TipoContrato> list(){
        return (List<TipoContrato>) tipoContratoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoContratoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoContratoRepository.existsById(id);
    }
}
