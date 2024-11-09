package com.mutual.SistemaMigracionMutual.Entidades;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "SALDOS")
public class Saldo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	@Column(name = "ID_SALDO")
    private Long idSaldo;
	
	@Column(name = "TIPO")
	private String tipo; 				// TIPO
	
	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha; 				// FECHA
	
	@Column(name = "SALDO")
	private BigDecimal saldo; 			// SALDO

	public Saldo() {		
	}

	public Saldo(String tipo, Date fecha, BigDecimal saldo) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Long getIdSaldo() {
		return idSaldo;
	}

	public void setIdSaldo(Long idSaldo) {
		this.idSaldo = idSaldo;
	}

}
