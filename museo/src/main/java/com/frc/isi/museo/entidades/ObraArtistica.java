package com.frc.isi.museo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "obra_artistica")
@Data
public class ObraArtistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "anio", nullable = false)
    private String anio;
    @Column(name = "monto_asegurado", nullable = false)
    private double montoAsegurado;
    @Column(name = "seguro_total", nullable = false)
    private boolean seguroTotal;
}
