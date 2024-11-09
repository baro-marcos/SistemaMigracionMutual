package com.mutual.SistemaMigracionMutual.Migraciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.linuxense.javadbf.DBFUtils;
import com.mutual.SistemaMigracionMutual.Entidades.MovimientoCajaAhorroComun;
import com.mutual.SistemaMigracionMutual.Servicios.MovCajaAhorroComunMigracionService;

public class MigracionTblMovCajaAhorroComun {
	
	MovCajaAhorroComunMigracionService migracionService = new MovCajaAhorroComunMigracionService();

	public boolean ejecutarProcesoMigracion() {

		DBFReader reader = null;

		// Borramos los registros de la tabla
		migracionService.limpiarTabla();
		
		try {
			
			Properties propiedades = new Properties();
            
            InputStream archivoProp = null;
            archivoProp = getClass().getClassLoader().getResourceAsStream("application.properties");;
            
            propiedades.load(archivoProp);
            
            String archivoDBF = propiedades.getProperty("archivo.COMUNMOV.dbf");
			
			FileInputStream inputArchivoDBF = new FileInputStream(archivoDBF);

			// Creamos un objeto DBFReader
			reader = new DBFReader(inputArchivoDBF);

			// Trabajamos con los registros
			DBFRow row;

			while ((row = reader.nextRow()) != null) {

				MovimientoCajaAhorroComun objeto = new MovimientoCajaAhorroComun();

				objeto.setNumeroSocio(row.getInt("SOCIO"));
				objeto.setOrden(row.getInt("ORDEN"));
				objeto.setFecha(row.getDate("FECHA"));
				objeto.setCodigo(row.getInt("CODIGO"));
				objeto.setMonto(row.getBigDecimal("MONTO"));
				objeto.setAnulado(row.getString("ANULADO"));
				objeto.setFechaAcre(row.getDate("FEC_ACRE"));
				objeto.setConcepto(row.getString("CONCEPTO"));
								
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
