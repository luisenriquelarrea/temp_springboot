package com.artplusplus.contpp.repository.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.artplusplus.contpp.model.Empleado;

public class EmpleadoSpecifications {
    public static Specification<Empleado> empleadoId(Long empleadoId) {
        return (root, query, builder) -> {
            return builder.equal(root.get("id"), empleadoId);
        };
    }

    public static Specification<Empleado> nombreCompleto(String nombreCompleto) {
        return (root, query, builder) -> {
            return builder.like(root.get("nombreCompleto"), "%"+nombreCompleto+"%");
        };
    }

    public static Specification<Empleado> rfc(String rfc) {
        return (root, query, builder) -> {
            return builder.equal(root.get("rfc"), rfc);
        };
    }
}
