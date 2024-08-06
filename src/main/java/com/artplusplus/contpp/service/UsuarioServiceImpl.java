package com.artplusplus.contpp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Usuario;
import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.repository.UsuarioRepository;
import com.artplusplus.contpp.utils.ObjectMapperUtils;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> list(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Usuario getById(Long id){
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<UsuarioDto> filteredList(Specification<Usuario> specs){
        List<Usuario> usuario = usuarioRepository.findAll(specs);
        return (List<UsuarioDto>)
            ObjectMapperUtils.mapAll(usuario, UsuarioDto.class);
    }

    @Override
    public Optional<Usuario> getByUsername(String username) {
        return usuarioRepository.findByUsernameAndStatus(username, 1);
    }

    @Override
    public Optional<Usuario> validUsernameAndPassword(String username, String password) {
        return getByUsername(username)
                .filter(usuario -> Objects.equals(password, usuario.getPassword()));
    }
}
