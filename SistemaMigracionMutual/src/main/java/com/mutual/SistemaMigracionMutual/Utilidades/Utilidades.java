package com.mutual.SistemaMigracionMutual.Utilidades;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Utilidades {
	
	public static void msg(Component comp, String cadena) {
		
        String mensaje = cadena;
        
        JOptionPane.showMessageDialog(comp, mensaje);
        
    }

}
