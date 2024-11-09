package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.Feriado;
import com.mutual.SistemaMigracionMutual.Servicios.FeriadoMigracionService;

public class MigracionTblFeriado {
	
	FeriadoMigracionService migracionService = new FeriadoMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");;
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.FERIADOS.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				Feriado objeto = new Feriado();

				objeto.setFecha(row.getDate("FECHA"));
				
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
