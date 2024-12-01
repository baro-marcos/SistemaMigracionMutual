package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.AyudaDolares;
import com.mutual.SistemaMigracionMutual.Servicios.AyudaDolaresMigracionService;

public class MigracionTblAyudaDolares {
	
	AyudaDolaresMigracionService migracionService = new AyudaDolaresMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");;
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.CAYUDAS_DOLARES.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				AyudaDolares objeto = new AyudaDolares();
				
				objeto.setNroAyuda(row.getInt("NRO_AYUDA"));
				objeto.setNumeroSocio(row.getInt("SOCIO"));
				objeto.setFechaAltaAyuda(row.getDate("FECHA"));
				objeto.setMontoSolicitado(row.getBigDecimal("MONT_SOL"));
				objeto.setInteres(row.getBigDecimal("INTER"));
				objeto.setCantidadCuotas(row.getInt("CAN_CUO"));
				objeto.setDestinoAyuda(row.getString("DESTINO"));
				objeto.setNroSocioGarante(row.getInt("GARANTE"));
				objeto.setMontoGastoAdministrativo(row.getBigDecimal("M_GASTO"));
				objeto.setMontoSellado(row.getBigDecimal("M_COB"));
				objeto.setInteresCuota(row.getBigDecimal("INT_CUO"));
				objeto.setInteresAcu(row.getBigDecimal("INT_ACU"));
				objeto.setAyudaSaldada(row.getString("SALDO"));
				objeto.setFechaLegales(row.getDate("LEGALES"));
				objeto.setMontoSelladoPcial(row.getBigDecimal("PCIAL"));
				objeto.setGarantia(row.getInt("GARANTIA"));
				objeto.setObservaciones(row.getString("OBSERVA"));
				objeto.setNroSocioGarante2(row.getInt("GARANTE2"));
				objeto.setNroSocioGarante3(0); // No esta en la tabla origen, es para un futuro
				// No se encuentran en la tabla DBF
				objeto.setMontoEfectivo(null); //row.getBigDecimal("EFECTIVO"
				objeto.setMontoTransferencia(null); //row.getBigDecimal("TRANSFE")
				objeto.setNroCheque1(null); //row.getInt("NROCHE1")
				objeto.setBancoCheque1(null); //row.getString("BANCO1")
				objeto.setMontoCheque1(null); //row.getBigDecimal("CHEQUE1")
				objeto.setNroCheque2(null); //row.getInt("NROCHE2")
				objeto.setBancoCheque2(null); //row.getString("BANCO2")
				objeto.setMontoCheque2(null); //row.getBigDecimal("CHEQUE2")
				objeto.setNroCheque3(null); //row.getInt("NROCHE3")
				objeto.setBancoCheque3(null); //row.getString("BANCO3")
				objeto.setMontoCheque3(null); //row.getBigDecimal("CHEQUE3")
				objeto.setNovacion(null); //row.getString("NOVACION")
				objeto.setSeguro(null); //row.getString("SEGURO")
								
				migracionService.cargarRegistroEnTabla(objeto);

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
