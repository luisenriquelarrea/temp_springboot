package com.artplusplus.contpp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleado_empresa")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class EmpleadoEmpresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Plaza plaza;

    private int empresaSueldosId;

    private int empresaContableId;

    private int empresaAsimiladosId;

    private int status;
}