package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired private UsuarioRepository usuarioRepository;

    public List<Usuario> listUsuario(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public boolean getById(Long id){
        return usuarioRepository.existsById(id);
    }

    public Usuario usuarioById(Long id){
        return usuarioRepository.findById(id).get();
    }
}
