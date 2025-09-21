package com.frc.isi.museo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "estilo_artistico")
@Data
public class EstiloArtistico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
	
    public EstiloArtistico(String nombre) {
		this.nombre = nombre;
	}
    
}
