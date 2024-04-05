package com.artplusplus.contpp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean getById(Long id){
        return usuarioRepository.existsById(id);
    }

    @Override
    public Optional<Usuario> getUserByName(String name) {
        return usuarioRepository.findByName(name);
    }

    @Override
    public UsuarioDto usuarioById(Long id){
        Usuario usuario = usuarioRepository.findById(id).get(); 
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class); 
        return usuarioDto;
    }

    @Override
    public Optional<Usuario> validUsernameAndPassword(String name, String password) {
        return getUserByName(name)
                .filter(usuario -> Objects.equals(password, usuario.getPassword()));
    }
}
