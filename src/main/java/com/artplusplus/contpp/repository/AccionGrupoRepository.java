package com.artplusplus.contpp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.artplusplus.contpp.model.AccionGrupo;

public interface AccionGrupoRepository extends CrudRepository<AccionGrupo, Long> {
    List<AccionGrupo> findByGrupoIdAndAccionOnNavbar(Long grupoId, int onNavbar);
}