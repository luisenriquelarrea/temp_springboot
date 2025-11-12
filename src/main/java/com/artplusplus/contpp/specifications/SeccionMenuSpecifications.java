package com.artplusplus.contpp.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.SeccionMenu;
import com.artplusplus.contpp.dto.SeccionMenuDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SeccionMenuSpecifications implements Specification<SeccionMenu>{
    private SeccionMenuDto seccionMenuDto = null;

    public SeccionMenuSpecifications(SeccionMenuDto seccionMenuDto){
        this.seccionMenuDto = seccionMenuDto;
    }

    @Override
    public Predicate toPredicate(Root<SeccionMenu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(seccionMenuDto.getMenu() != null && seccionMenuDto.getMenu().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("menu").get("id"), 
                seccionMenuDto.getMenu().getId()
            ));
        }
        if(seccionMenuDto.getDescripcion() != null){
            predicates.add(criteriaBuilder.like(
                root.get("descripcion"), 
                "%"+seccionMenuDto.getDescripcion()+"%"
            ));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
