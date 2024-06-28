package com.artplusplus.contpp.dto;

import com.artplusplus.contpp.model.Departamento;
import com.artplusplus.contpp.model.Escolaridad;
import com.artplusplus.contpp.model.PeriodicidadPago;
import com.artplusplus.contpp.model.Puesto;
import com.artplusplus.contpp.model.Sucursal;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "empleado")
@Getter 
@Setter
public class EmpleadoDto {
    private Long id;

    private Sucursal sucursal;

    private Departamento departamento;

    private Puesto puesto;

    private PeriodicidadPago periodicidadPago;

    private Escolaridad escolaridad;

    private String nombreCompleto;

    private String rfc;

    private String curp;

    private String nss;

    private String fechaInicioLaboralValor1;

    private String fechaInicioLaboralValor2;

    private String fechaAltaImss;

    private int status;
}
