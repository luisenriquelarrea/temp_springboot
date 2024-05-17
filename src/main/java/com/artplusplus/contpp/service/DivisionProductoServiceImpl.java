package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.DivisionProducto;
import com.artplusplus.contpp.repository.DivisionProductoRepository;

import java.util.List;

@Service
public class DivisionProductoServiceImpl implements DivisionProductoService {
    @Autowired
    private DivisionProductoRepository divisionProductoRepository;

    @Override
    public DivisionProducto save(DivisionProducto divisionProducto) {
        return divisionProductoRepository.save(divisionProducto);
    }

    @Override
    public List<DivisionProducto> list(){
        return (List<DivisionProducto>) divisionProductoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        divisionProductoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return divisionProductoRepository.existsById(id);
    }
}
