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
@Table(name = "recibo_tipo_otro_pago")
@Data
@RequiredArgsConstructor
@Getter
@Setter
public class ReciboTipoOtroPago {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recibo recibo;

    @ManyToOne
    private TipoOtroPago tipoOtroPago;

    private float monto;

    private int status;
}