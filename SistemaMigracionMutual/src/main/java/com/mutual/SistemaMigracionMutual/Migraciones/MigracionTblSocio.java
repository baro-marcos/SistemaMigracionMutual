package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.Socio;
import com.mutual.SistemaMigracionMutual.Servicios.SocioMigracionService;

public class MigracionTblSocio {
	
	SocioMigracionService socioMigracionService = new SocioMigracionService();

	public boolean ejecutarProcesoMigracionSocio() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		socioMigracionService.limpiarTablaSocio();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.SOCIO.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				Socio socio = new Socio();

				socio.setNumeroSocio(row.getInt("SOCIO"));
				socio.setApellidoNombre(row.getString("APENOM"));
				socio.setDomicilio(row.getString("DOMICILIO"));
				socio.setLocalidad(row.getString("LOCALIDAD"));
				socio.setCodigoPostal(row.getInt("CP"));
				socio.setTipoDocumento(row.getString("TIPDOC"));
				socio.setNumeroDocumento(row.getInt("NRODOC"));
				socio.setFechaNacimiento(row.getDate("FECH_NAC"));
				socio.setEstadoCivil(row.getString("ESTADO_CIV"));
				socio.setProfesion(row.getString("PROFESION"));
				socio.setCategoria(row.getString("CATEGORIA"));
				socio.setFechaIngreso(row.getDate("FECH_INGRE"));
				socio.setMontoMaximo(row.getBigDecimal("MONT_MAX"));
				socio.setFechaEgreso(row.getDate("FECH_EGRE"));
				socio.setFechaNacimiento_2(row.getDate("FECHNAC"));
				socio.setFechaIngreso_2(row.getDate("FECHINGRE"));
				socio.setFechaEgreso_2(row.getDate("FECHAEGRE"));
				socio.setCuit(row.getString("CUIT"));
				socio.setResponsable(row.getString("RESPO"));
				socio.setTelefono(row.getString("TEL"));
				socio.setEmail(row.getString("EMAIL"));
				socio.setNacionalidad(row.getString("NACIONALID"));
				socio.setCenso(row.getDate("CENSO"));
				socio.setTrabajo(row.getString("TRABAJO"));
				socio.setApellidoPadre(row.getString("APELLPADRE"));
				socio.setNombrePadre(row.getString("NOMBRPADRE"));
				socio.setVivePadre(row.getString("VIVEP"));
				socio.setApellidoMadre(row.getString("APELLMADRE"));
				socio.setNombreMadre(row.getString("NOMBRMADRE"));
				socio.setViveMadre(row.getString("VIVEM"));
				socio.setApellidoBeneficiario(row.getString("APELLBENEF"));
				socio.setNombreBeneficiario(row.getString("NOMBRBENEF"));
				socio.setCarencia(row.getString("CARENCIA"));
				socio.setApellidoCasado(row.getString("APELLCASAD"));
				socio.setTipper(row.getString("TIPPER"));
				socio.setConjunta(row.getString("CONJUNTA"));
				socio.setLegajo(row.getString("LEGAJO"));
				socio.setCompleto(row.getString("COMPLETO"));
				socio.setOperador(row.getString("OPERADOR"));
				socio.setFechaVencimiento(row.getDate("FECHAVTO"));
				socio.setDomicilioContractual(row.getString("DOMCONTRAC"));
				socio.setListado(row.getString("LISTADO"));
				socio.setGarantias(row.getString("GARANTIAS"));
				socio.setConstanciaInscripto(row.getString("CONST_INSC"));
				socio.setDdjj_iibb(row.getString("DDJJ_IIBB"));
				socio.setDdjj_ganancias(row.getString("DDJJ_GCIAS"));
				socio.setDdjj_bienesPersonales(row.getString("DDJJ_BSPER"));
				socio.setPagoMonotributo(row.getString("PAGO_MONOT"));
				socio.setPagoIVA(row.getString("PAGO_IVA"));
				socio.setPagoIIBB(row.getString("PAGO_IIBB"));
				socio.setReciboSueldo(row.getString("RECI_SUELD"));
				socio.setFotocopiaDNI(row.getString("FOTOC_DNI"));
				socio.setFotocopiaImpuesto(row.getString("FOTOC_IMPU"));
				socio.setLiciFondo(row.getString("LICI_FONDO"));
				socio.setPep(row.getString("PEP"));
				socio.setPerfil(row.getBigDecimal("PERFIL"));
				socio.setRiesgo(row.getString("RIESGO"));
				socio.setModalidad(row.getString("MODALIDAD"));
				socio.setTerror(row.getString("TERROR"));
				socio.setSexo(row.getString("SEXO"));
				socio.setObligado(row.getString("OBLIGADO"));
				socio.setVencimientoObl(row.getDate("VTOOBL"));
				socio.setVencimientoPep(row.getDate("VTOPEP"));
				socio.setVencimientoTer(row.getDate("VTOTER"));
				socio.setProvincia(row.getString("PROVINCIA"));
				socio.setBeneficiarioFinal(row.getString("BENEFFINAL"));
				socio.setEmail1(row.getString("EMAIL1"));
				socio.setDigital(row.getString("DIGITAL"));
				socio.setMandar(row.getString("MANDAR"));
				socio.setAcred(row.getString("ACRED"));
				socio.setApode(row.getString("APODE"));
				socio.setPoder(row.getString("PODER"));
				socio.setApodeSocio1(row.getInt("APODESOC1"));
				socio.setApodeSocio2(row.getInt("APODESOC2"));
				socio.setApodeSocio3(row.getInt("APODESOC3"));
				socio.setPais(row.getString("PAIS"));
				socio.setLocalidadCont(row.getString("LOCCONTR"));
				socio.setProvinciaCont(row.getString("PCIACONT"));
				socio.setPaisCont(row.getString("PAISCONT"));
				socio.setCelular(row.getString("CELULAR"));
				socio.setLugar(row.getString("LUGAR"));
				socio.setVencimientoRUPP(row.getDate("VTORUPP"));
				socio.setDomGt1(row.getString("DOMGT1"));
				socio.setTipoGt1(row.getString("TIPGT1"));
				socio.setM1(row.getString("M1"));
				socio.setMontoGt1(row.getBigDecimal("MONTGT1"));
				socio.setVencimientoGt1(row.getDate("VTOGT1"));
				socio.setDomGt2(row.getString("DOMGT2"));
				socio.setTipoGt2(row.getString("TIPGT2"));
				socio.setM2(row.getString("M2"));
				socio.setMontoGt2(row.getBigDecimal("MONTGT2"));
				socio.setVencimientoGt2(row.getDate("VTOGT2"));
				socio.setDomGt3(row.getString("DOMGT3"));
				socio.setTipoGt3(row.getString("TIPGT3"));
				socio.setM3(row.getString("M3"));
				socio.setMontoGt3(row.getBigDecimal("MONTGT3"));
				socio.setVencimientoGt3(row.getDate("VTOGT3"));
				socio.setActi1(row.getString("ACTI1"));
				socio.setActi2(row.getString("ACTI2"));
				socio.setPropo(row.getString("PROPO"));
				socio.setCanal(row.getString("CANAL"));
				socio.setFechaVencimientoTope(row.getDate("FECVTOPE"));

				socioMigracionService.cargarRegistroEnTablaSocio(socio);

			}
			
			return true;

		} catch (Exception e) {

//			System.err.println("Error al correr la migracion: " + e.getMessage() + "\n");
//			e.printStackTrace();
			
			return false;

		} finally {

			DBFUtils.close(reader);

		}

	}

}
