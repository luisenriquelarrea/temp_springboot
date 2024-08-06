package com.artplusplus.contpp.service;

import com.artplusplus.contpp.dto.UsuarioDto;
import com.artplusplus.contpp.model.Usuario;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
public interface UsuarioService {
    //Create operation
    Usuario save(Usuario usuario);

    //Read operation
    List<Usuario> list();

    //Delete operation
    void deleteById(Long id);

    //Exists by id operation
    boolean existsById(Long id);

    //Get entity by id
    Usuario getById(Long id);

    //Read operation filtered by specifications
    List<UsuarioDto> filteredList(Specification<Usuario> specs);

    /* 
     * User defined method 
     */
    Optional<Usuario> getByUsername(String username);

    /* 
     * User defined method 
     */
    Optional<Usuario> validUsernameAndPassword(String username, String password);
}