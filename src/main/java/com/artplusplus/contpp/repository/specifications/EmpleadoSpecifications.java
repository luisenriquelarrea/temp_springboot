package com.artplusplus.contpp.repository.specifications;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.dto.EmpleadoDto;
import com.artplusplus.contpp.model.Empleado;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmpleadoSpecifications implements Specification<Empleado>{
    private EmpleadoDto empleadoDto = null;

    public EmpleadoSpecifications(EmpleadoDto empleadoDto){
        this.empleadoDto = empleadoDto;
    }

    @Override
    public Predicate toPredicate(Root<Empleado> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(empleadoDto.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"), empleadoDto.getId()));
        }
        if(empleadoDto.getRfc() != null){
            predicates.add(criteriaBuilder.equal(root.get("rfc"), empleadoDto.getRfc()));
        }
        if(empleadoDto.getCurp() != null){
            predicates.add(criteriaBuilder.equal(root.get("curp"), empleadoDto.getCurp()));
        }
        if(empleadoDto.getFechaInicioLaboralValor1() != null && empleadoDto.getFechaInicioLaboralValor2() != null){
            predicates.add(criteriaBuilder.between(root.get("fechaInicioLaboral"), 
                empleadoDto.getFechaInicioLaboralValor1(), empleadoDto.getFechaInicioLaboralValor2()));
        }
        if(empleadoDto.getSucursal() != null && empleadoDto.getSucursal().getId() != null){
            predicates.add(criteriaBuilder.equal(
                root.join("sucursal").get("id"), 
                empleadoDto.getSucursal().getId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
