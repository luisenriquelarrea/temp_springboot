package com.artplusplus.contpp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.model.UsuarioDto;
import com.artplusplus.contpp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean getById(Long id){
        return usuarioRepository.existsById(id);
    }

    public UsuarioDto usuarioById(Long id){
        Usuario usuario = usuarioRepository.findById(id).get(); 
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class); 
        return usuarioDto;
    }
}
