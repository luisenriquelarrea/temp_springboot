package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.GrupoProducto;
import com.artplusplus.contpp.repository.GrupoProductoRepository;

import java.util.List;

@Service
public class GrupoProductoServiceImpl implements GrupoProductoService {
    @Autowired
    private GrupoProductoRepository grupoProductoRepository;

    @Override
    public GrupoProducto save(GrupoProducto grupoProducto) {
        return grupoProductoRepository.save(grupoProducto);
    }

    @Override
    public List<GrupoProducto> list(){
        return (List<GrupoProducto>) grupoProductoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        grupoProductoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return grupoProductoRepository.existsById(id);
    }
}
