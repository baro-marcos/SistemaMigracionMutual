package com.mutual.SistemaMigracionMutual.Entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GARANTIA")
public class Garantia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "GARANTIA")
	private String garantia;
	
	@Column(name = "PORCENTAJE")
	private BigDecimal porcentaje;						//PORCE

	public Garantia() {
		
	}

	public Garantia(Integer codigo, String garantia, BigDecimal porcentaje) {
		super();
		this.codigo = codigo;
		this.garantia = garantia;
		this.porcentaje = porcentaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

}
