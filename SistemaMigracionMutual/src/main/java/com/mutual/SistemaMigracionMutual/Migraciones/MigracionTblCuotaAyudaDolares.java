package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.CuotaAyudaDolares;
import com.mutual.SistemaMigracionMutual.Servicios.CuotaAyudaDolaresMigracionService;

public class MigracionTblCuotaAyudaDolares {
	
	CuotaAyudaDolaresMigracionService migracionService = new CuotaAyudaDolaresMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");;
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.CUOTASAYUDAS_DOLARES.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				CuotaAyudaDolares objeto = new CuotaAyudaDolares();
				
				objeto.setNumeroAyuda(row.getInt("AYUDA"));
				objeto.setNumeroCuota(row.getInt("CUOTA"));
				objeto.setMontoCuota(row.getBigDecimal("MONTO"));
				objeto.setFechaVtoCuota(row.getDate("VTO"));
				objeto.setCartaDocumentoEnviada(row.getString("CARTA"));
												
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
