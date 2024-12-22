package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.AyudaFrances;
import com.mutual.SistemaMigracionMutual.Servicios.AyudaFrancesMigracionService;

public class MigracionTblAyudaFrances {
	
	AyudaFrancesMigracionService migracionService = new AyudaFrancesMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.PESAYUDA_FRANCES.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				AyudaFrances objeto = new AyudaFrances();
				
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
				objeto.setMontoEfectivo(row.getBigDecimal("EFECTIVO"));
				objeto.setMontoTransferencia(row.getBigDecimal("TRANSFE"));
				objeto.setNroCheque1(row.getInt("NROCHE1"));
				objeto.setBancoCheque1(row.getString("BANCO1"));
				objeto.setMontoCheque1(row.getBigDecimal("CHEQUE1"));
				objeto.setNroCheque2(row.getInt("NROCHE2"));
				objeto.setBancoCheque2(row.getString("BANCO2"));
				objeto.setMontoCheque2(row.getBigDecimal("CHEQUE2"));
				objeto.setNroCheque3(row.getInt("NROCHE3"));
				objeto.setBancoCheque3(row.getString("BANCO3"));
				objeto.setMontoCheque3(row.getBigDecimal("CHEQUE3"));
				objeto.setNovacion(row.getString("NOVACION"));
				objeto.setMesesGracia(row.getInt("GRACIA"));
				objeto.setTsMesesGracia(row.getBigDecimal("TSGRACIA"));
				objeto.setSeguro(row.getString("SEGURO"));
								
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
