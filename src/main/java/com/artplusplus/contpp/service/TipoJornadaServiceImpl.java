package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoJornada;
import com.artplusplus.contpp.repository.TipoJornadaRepository;

import java.util.List;

@Service
public class TipoJornadaServiceImpl implements TipoJornadaService {
    @Autowired
    private TipoJornadaRepository tipoJornadaRepository;

    @Override
    public TipoJornada save(TipoJornada tipoJornada) {
        return tipoJornadaRepository.save(tipoJornada);
    }

    @Override
    public List<TipoJornada> list(){
        return (List<TipoJornada>) tipoJornadaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoJornadaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoJornadaRepository.existsById(id);
    }
}
