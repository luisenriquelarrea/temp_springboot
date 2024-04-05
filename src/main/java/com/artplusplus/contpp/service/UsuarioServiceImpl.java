package com.artplusplus.contpp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean getById(Long id){
        return usuarioRepository.existsById(id);
    }

    public Optional<Usuario> getUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public UsuarioDto usuarioById(Long id){
        Usuario usuario = usuarioRepository.findById(id).get(); 
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class); 
        return usuarioDto;
    }

    public Optional<Usuario> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}
