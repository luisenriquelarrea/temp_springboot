package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.TipoProducto;
import com.artplusplus.contpp.repository.TipoProductoRepository;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    public TipoProducto save(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    public List<TipoProducto> list(){
        return (List<TipoProducto>) tipoProductoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        tipoProductoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tipoProductoRepository.existsById(id);
    }
}
