package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoIncidencia;
import com.artplusplus.contpp.repository.TipoIncidenciaRepository;

import java.util.List;

@Service
public class TipoIncidenciaServiceImpl implements TipoIncidenciaService {
    @Autowired
    private TipoIncidenciaRepository tipoIncidenciaRepository;

    @Override
    public TipoIncidencia save(TipoIncidencia tipoIncidencia) {
        return tipoIncidenciaRepository.save(tipoIncidencia);
    }

    @Override
    public List<TipoIncidencia> list(){
        return (List<TipoIncidencia>) tipoIncidenciaRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoIncidenciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoIncidenciaRepository.existsById(id);
    }
}
