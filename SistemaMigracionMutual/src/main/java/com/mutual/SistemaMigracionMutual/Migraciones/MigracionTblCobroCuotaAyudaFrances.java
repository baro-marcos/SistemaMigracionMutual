package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.CobroCuotaAyudaFrances;
import com.mutual.SistemaMigracionMutual.Servicios.CobroCuotaAyudaFrancesMigracionService;

public class MigracionTblCobroCuotaAyudaFrances {
	
	CobroCuotaAyudaFrancesMigracionService migracionService = new CobroCuotaAyudaFrancesMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.PCOBROS_FRANCES.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				CobroCuotaAyudaFrances objeto = new CobroCuotaAyudaFrances();
				
				objeto.setNumeroAyuda(row.getInt("AYUDA"));
				objeto.setNumeroCuota(row.getInt("CUOTA"));
				objeto.setMontoCuota(row.getBigDecimal("MONTO"));
				objeto.setCer(row.getBigDecimal("CER"));
				objeto.setFechaPagoCuota(row.getDate("FECHA"));
				objeto.setCargos(row.getBigDecimal("CARGOS"));
				objeto.setDescuento(row.getBigDecimal("DESCTO"));
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