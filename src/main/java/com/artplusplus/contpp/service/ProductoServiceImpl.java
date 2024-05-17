package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.Producto;
import com.artplusplus.contpp.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> list(){
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productoRepository.existsById(id);
    }
}
