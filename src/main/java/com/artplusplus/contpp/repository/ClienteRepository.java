package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
