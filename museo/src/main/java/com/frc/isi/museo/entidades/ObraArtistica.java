package com.frc.isi.museo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    @JoinColumn(name = "museo_id", nullable = false)
    private Museo museo;
    @OneToOne
    @JoinColumn(name = "estilo_artistico_id", nullable = false)
    private EstiloArtistico estilo;
    @OneToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
	public ObraArtistica(String nombre, String anio, double montoAsegurado, boolean seguroTotal, Museo museo,
			EstiloArtistico estilo, Autor autor) {
		this.nombre = nombre;
		this.anio = anio;
		this.montoAsegurado = montoAsegurado;
		this.seguroTotal = seguroTotal;
		this.museo = museo;
		this.estilo = estilo;
		this.autor = autor;
	}
    

}
