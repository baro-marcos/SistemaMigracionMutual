package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.Parametro;
import com.mutual.SistemaMigracionMutual.Servicios.ParametroMigracionService;

public class MigracionTblParametro {
	
	ParametroMigracionService migracionService = new ParametroMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.TABLAS.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				Parametro objeto = new Parametro();

				objeto.setN1(row.getBigDecimal("N1"));
				objeto.setN2(row.getBigDecimal("N2"));
				objeto.setN3(row.getBigDecimal("N3"));
				objeto.setN4(row.getBigDecimal("N4"));
				objeto.setSellcrepe1(row.getBigDecimal("SELLCREPE1"));
				objeto.setSellcrepe2(row.getBigDecimal("SELLCREPE2"));
				objeto.setN5(row.getBigDecimal("N5"));
				objeto.setN6(row.getBigDecimal("N6"));
				objeto.setN7(row.getBigDecimal("N7"));
				objeto.setN8(row.getBigDecimal("N8"));
				objeto.setN9(row.getBigDecimal("N9"));
				objeto.setMinimo(row.getBigDecimal("MINIMO"));
				objeto.setPorAdmini(row.getBigDecimal("POR_ADMINI"));
				objeto.setPorProedi(row.getBigDecimal("POR_PROEDI"));
								
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
