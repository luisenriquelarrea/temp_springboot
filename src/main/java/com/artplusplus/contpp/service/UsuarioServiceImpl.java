package com.artplusplus.contpp.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.repository.UsuarioRepository;

import java.util.Optional;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDto save(Usuario seccionMenu) {
        Usuario usuario = usuarioRepository.save(seccionMenu);
        return (UsuarioDto) modelMapper.map(usuario, UsuarioDto.class);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return usuarioRepository.existsById(id);
    }

    @Override
    public Optional<Usuario> getByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UsuarioDto getById(Long id){
        Usuario usuario = usuarioRepository.findById(id).get(); 
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class); 
        return usuarioDto;
    }

    @Override
    public Optional<Usuario> validUsernameAndPassword(String username, String password) {
        return getByUsername(username)
                .filter(usuario -> Objects.equals(password, usuario.getPassword()));
    }
}
