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
@Table(name = "CUOTAS_AYUDAS_FRANCES")
public class CuotaAyudaFrances {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
	@Column(name = "ID_CUOTA_AYUDA_FRANCES")
    private Long idCuotaAyudaFrances;
	
	@Column(name = "NRO_AYUDA")
	private Integer numeroAyuda; 				// AYUDA
	
	@Column(name = "NUMERO_CUOTA")
	private Integer numeroCuota; 				// CUOTA
			
	@Column(name = "MONTO_CUOTA")
	private BigDecimal montoCuota;				// MONTO
	
	@Column(name = "INTERES_CUOTA")
	private BigDecimal interesCuota;			// INTERES
	
	@Column(name = "FECHA_VTO_CUOTA")
	@Temporal(TemporalType.DATE)
	private Date fechaVtoCuota; 				// VTO
	
	@Column(name = "CARTA_DOCUMENTO_ENVIADA")
	private String cartaDocumentoEnviada; 		// CARTA
	
	@Column(name = "MONTO_EFECTIVO")
	private BigDecimal montoEfectivo;			// EFECTIVO
	
	@Column(name = "MONTO_TRANSFERENCIA")
	private BigDecimal montoTransferencia;		// TRANSFE
	
	@Column(name = "NRO_CHEQUE_1")
	private Integer nroCheque1; 				// NROCHE1
	
	@Column(name = "BANCO_CHEQUE_1")
	private String bancoCheque1; 				// BANCO1
	
	@Column(name = "MONTO_CHEQUE_1")
	private BigDecimal montoCheque1;			// CHEQUE1
	
	@Column(name = "NRO_CHEQUE_2")
	private Integer nroCheque2; 				// NROCHE2
	
	@Column(name = "BANCO_CHEQUE_2")
	private String bancoCheque2; 				// BANCO2
	
	@Column(name = "MONTO_CHEQUE_2")
	private BigDecimal montoCheque2;			// CHEQUE2
	
	@Column(name = "NRO_CHEQUE_3")
	private Integer nroCheque3; 				// NROCHE3
	
	@Column(name = "BANCO_CHEQUE_3")
	private String bancoCheque3; 				// BANCO3
	
	@Column(name = "MONTO_CHEQUE_3")
	private BigDecimal montoCheque3;			// CHEQUE3
	
	@Column(name = "NOVACION")
	private String novacion; 					// NOVACION

	public CuotaAyudaFrances() {
		
	}

	public CuotaAyudaFrances(Long idCuotaAyudaFrances, Integer numeroAyuda, Integer numeroCuota, BigDecimal montoCuota,
			BigDecimal interesCuota, Date fechaVtoCuota, String cartaDocumentoEnviada, BigDecimal montoEfectivo,
			BigDecimal montoTransferencia, Integer nroCheque1, String bancoCheque1, BigDecimal montoCheque1,
			Integer nroCheque2, String bancoCheque2, BigDecimal montoCheque2, Integer nroCheque3, String bancoCheque3,
			BigDecimal montoCheque3, String novacion) {
		super();
		this.idCuotaAyudaFrances = idCuotaAyudaFrances;
		this.numeroAyuda = numeroAyuda;
		this.numeroCuota = numeroCuota;
		this.montoCuota = montoCuota;
		this.interesCuota = interesCuota;
		this.fechaVtoCuota = fechaVtoCuota;
		this.cartaDocumentoEnviada = cartaDocumentoEnviada;
		this.montoEfectivo = montoEfectivo;
		this.montoTransferencia = montoTransferencia;
		this.nroCheque1 = nroCheque1;
		this.bancoCheque1 = bancoCheque1;
		this.montoCheque1 = montoCheque1;
		this.nroCheque2 = nroCheque2;
		this.bancoCheque2 = bancoCheque2;
		this.montoCheque2 = montoCheque2;
		this.nroCheque3 = nroCheque3;
		this.bancoCheque3 = bancoCheque3;
		this.montoCheque3 = montoCheque3;
		this.novacion = novacion;
	}

	public Long getIdCuotaAyudaFrances() {
		return idCuotaAyudaFrances;
	}

	public void setIdCuotaAyudaFrances(Long idCuotaAyudaFrances) {
		this.idCuotaAyudaFrances = idCuotaAyudaFrances;
	}

	public Integer getNumeroAyuda() {
		return numeroAyuda;
	}

	public void setNumeroAyuda(Integer numeroAyuda) {
		this.numeroAyuda = numeroAyuda;
	}

	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public BigDecimal getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(BigDecimal montoCuota) {
		this.montoCuota = montoCuota;
	}

	public BigDecimal getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(BigDecimal interesCuota) {
		this.interesCuota = interesCuota;
	}

	public Date getFechaVtoCuota() {
		return fechaVtoCuota;
	}

	public void setFechaVtoCuota(Date fechaVtoCuota) {
		this.fechaVtoCuota = fechaVtoCuota;
	}

	public String getCartaDocumentoEnviada() {
		return cartaDocumentoEnviada;
	}

	public void setCartaDocumentoEnviada(String cartaDocumentoEnviada) {
		this.cartaDocumentoEnviada = cartaDocumentoEnviada;
	}

	public BigDecimal getMontoEfectivo() {
		return montoEfectivo;
	}

	public void setMontoEfectivo(BigDecimal montoEfectivo) {
		this.montoEfectivo = montoEfectivo;
	}

	public BigDecimal getMontoTransferencia() {
		return montoTransferencia;
	}

	public void setMontoTransferencia(BigDecimal montoTransferencia) {
		this.montoTransferencia = montoTransferencia;
	}

	public Integer getNroCheque1() {
		return nroCheque1;
	}

	public void setNroCheque1(Integer nroCheque1) {
		this.nroCheque1 = nroCheque1;
	}

	public String getBancoCheque1() {
		return bancoCheque1;
	}

	public void setBancoCheque1(String bancoCheque1) {
		this.bancoCheque1 = bancoCheque1;
	}

	public BigDecimal getMontoCheque1() {
		return montoCheque1;
	}

	public void setMontoCheque1(BigDecimal montoCheque1) {
		this.montoCheque1 = montoCheque1;
	}

	public Integer getNroCheque2() {
		return nroCheque2;
	}

	public void setNroCheque2(Integer nroCheque2) {
		this.nroCheque2 = nroCheque2;
	}

	public String getBancoCheque2() {
		return bancoCheque2;
	}

	public void setBancoCheque2(String bancoCheque2) {
		this.bancoCheque2 = bancoCheque2;
	}

	public BigDecimal getMontoCheque2() {
		return montoCheque2;
	}

	public void setMontoCheque2(BigDecimal montoCheque2) {
		this.montoCheque2 = montoCheque2;
	}

	public Integer getNroCheque3() {
		return nroCheque3;
	}

	public void setNroCheque3(Integer nroCheque3) {
		this.nroCheque3 = nroCheque3;
	}

	public String getBancoCheque3() {
		return bancoCheque3;
	}

	public void setBancoCheque3(String bancoCheque3) {
		this.bancoCheque3 = bancoCheque3;
	}

	public BigDecimal getMontoCheque3() {
		return montoCheque3;
	}

	public void setMontoCheque3(BigDecimal montoCheque3) {
		this.montoCheque3 = montoCheque3;
	}

	public String getNovacion() {
		return novacion;
	}

	public void setNovacion(String novacion) {
		this.novacion = novacion;
	}

}
