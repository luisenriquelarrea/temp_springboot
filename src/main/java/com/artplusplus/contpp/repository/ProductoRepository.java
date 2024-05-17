package com.artplusplus.contpp.repository;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
