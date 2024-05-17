package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ClaseProducto;
import com.artplusplus.contpp.repository.ClaseProductoRepository;

import java.util.List;

@Service
public class ClaseProductoServiceImpl implements ClaseProductoService {
    @Autowired
    private ClaseProductoRepository claseProductoRepository;

    @Override
    public ClaseProducto save(ClaseProducto claseProducto) {
        return claseProductoRepository.save(claseProducto);
    }

    @Override
    public List<ClaseProducto> list(){
        return (List<ClaseProducto>) claseProductoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        claseProductoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return claseProductoRepository.existsById(id);
    }
}
