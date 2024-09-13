package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.AccionGrupoDto;
import com.artplusplus.contpp.model.AccionGrupo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AccionGrupoSpecifications implements Specification<AccionGrupo>{
    private AccionGrupoDto accionGrupoDto = null;

    public AccionGrupoSpecifications(AccionGrupoDto accionGrupoDto){
        this.accionGrupoDto = accionGrupoDto;
    }

    @Override
    public Predicate toPredicate(Root<AccionGrupo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(accionGrupoDto.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"), accionGrupoDto.getId()));
        }
        if(accionGrupoDto.getGrupo() != null && accionGrupoDto.getGrupo().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("grupo").get("id"), 
                accionGrupoDto.getGrupo().getId()));
        }
        if(accionGrupoDto.getSeccionMenu() != null && accionGrupoDto.getSeccionMenu().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("accion")
                    .join("seccionMenu")
                    .get("id"), 
                accionGrupoDto.getSeccionMenu().getId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}