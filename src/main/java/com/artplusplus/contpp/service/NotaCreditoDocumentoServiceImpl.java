package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artplusplus.contpp.model.NotaCreditoDocumento;
import com.artplusplus.contpp.repository.NotaCreditoDocumentoRepository;

import java.util.List;

@Service
public class NotaCreditoDocumentoServiceImpl implements NotaCreditoDocumentoService {
    @Autowired
    private NotaCreditoDocumentoRepository notaCreditoDocumentoRepository;

    @Override
    public NotaCreditoDocumento save(NotaCreditoDocumento notaCreditoDocumento) {
        return notaCreditoDocumentoRepository.save(notaCreditoDocumento);
    }

    @Override
    public List<NotaCreditoDocumento> list(){
        return (List<NotaCreditoDocumento>) notaCreditoDocumentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        notaCreditoDocumentoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return notaCreditoDocumentoRepository.existsById(id);
    }
}
