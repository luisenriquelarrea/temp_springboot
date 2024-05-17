package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.ComplementoPagoDocumento;
import com.artplusplus.contpp.repository.ComplementoPagoDocumentoRepository;

import java.util.List;

@Service
public class ComplementoPagoDocumentoServiceImpl implements ComplementoPagoDocumentoService {
    @Autowired
    private ComplementoPagoDocumentoRepository complementoPagoDocumentoRepository;

    @Override
    public ComplementoPagoDocumento save(ComplementoPagoDocumento complementoPagoDocumento) {
        return complementoPagoDocumentoRepository.save(complementoPagoDocumento);
    }

    @Override
    public List<ComplementoPagoDocumento> list(){
        return (List<ComplementoPagoDocumento>) complementoPagoDocumentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        complementoPagoDocumentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return complementoPagoDocumentoRepository.existsById(id);
    }
}
