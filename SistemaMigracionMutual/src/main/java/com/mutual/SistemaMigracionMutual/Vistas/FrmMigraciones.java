package com.mutual.SistemaMigracionMutual.Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblAyudaDolares;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblAyudaFrances;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblAyudaPesos;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCobro;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCobroCuotaAyudaDolares;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCobroCuotaAyudaFrances;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCobroCuotaAyudaPesos;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCuota;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCuotaAyudaDolares;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCuotaAyudaFrances;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblCuotaAyudaPesos;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblFeriado;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblGarantia;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblMovCajaAhorroComun;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblParametro;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblSaldo;
import com.mutual.SistemaMigracionMutual.Migraciones.MigracionTblSocio;
import com.mutual.SistemaMigracionMutual.Utilidades.Utilidades;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

/**
*
* @author Marcos Baró
*/

public class FrmMigraciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnMigracionTblCuotaFrances;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMigraciones frame = new FrmMigraciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMigraciones() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMigraciones.class.getResource("/com/mutual/SistemaMigracionMutual/Imagenes/migration_icon_16_16.png")));
		
		setTitle("Migraciones Sistema Mutual");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // Centrar en la pantalla

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Migraciones tablas DBF a MySQL");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTitulo.setBounds(24, 27, 657, 21);
		contentPane.add(lblTitulo);
		
		//Socio
		
		JButton btnMigracionSocio = new JButton("Migración tabla Socios");
				
		btnMigracionSocio.setBounds(24, 69, 246, 21);
		contentPane.add(btnMigracionSocio);
				
		btnMigracionSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblSocio migracionTblSocio = new MigracionTblSocio();
		    	
		    	boolean finalizoOK = migracionTblSocio.ejecutarProcesoMigracionSocio();
		    	
		    	if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionSocio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblSocio migracionTblSocio = new MigracionTblSocio();
			    	
					boolean finalizoOK = migracionTblSocio.ejecutarProcesoMigracionSocio();
			    	
			    	if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		//Cobro
		
		JButton btnMigracionCobro = new JButton("Migración tabla Cobros");
		
		btnMigracionCobro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCobro migracionTblCobro = new MigracionTblCobro();
				
				boolean finalizoOK = migracionTblCobro.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionCobro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCobro migracionTblCobro = new MigracionTblCobro();
					
					boolean finalizoOK = migracionTblCobro.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionCobro.setBounds(24, 100, 246, 21);
		contentPane.add(btnMigracionCobro);
				
		//Cuota
		
		JButton btnMigracionCuota = new JButton("Migración tabla Cuotas");
				
		btnMigracionCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCuota migracionTblCuota = new MigracionTblCuota();
				
				boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionCuota.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCuota migracionTblCuota = new MigracionTblCuota();
					
					boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});		
		
		btnMigracionCuota.setBounds(24, 131, 246, 21);
		contentPane.add(btnMigracionCuota);
		
		//Feriado
		
		JButton btnMigracionFeriados = new JButton("Migración tabla Feriados");
				
		btnMigracionFeriados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblFeriado migracionTblFeriado = new MigracionTblFeriado();
				
				boolean finalizoOK = migracionTblFeriado.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionFeriados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblFeriado migracionTblFeriado = new MigracionTblFeriado();
					
					boolean finalizoOK = migracionTblFeriado.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
				
		btnMigracionFeriados.setBounds(24, 162, 246, 21);
		contentPane.add(btnMigracionFeriados);
				
		// Mov Caja ahorro comun
		
		JButton btnMigracionMovCajaAhorroComun = new JButton("Migración Mov Caja Ahorro Común");
				
		btnMigracionMovCajaAhorroComun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblMovCajaAhorroComun migracionTblMovCajaAhorroComun = new MigracionTblMovCajaAhorroComun();
				
				boolean finalizoOK = migracionTblMovCajaAhorroComun.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionMovCajaAhorroComun.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblMovCajaAhorroComun migracionTblMovCajaAhorroComun = new MigracionTblMovCajaAhorroComun();
					
					boolean finalizoOK = migracionTblMovCajaAhorroComun.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionMovCajaAhorroComun.setBounds(24, 193, 246, 21);
		contentPane.add(btnMigracionMovCajaAhorroComun);
		
		// Saldo
		
		JButton btnMigracionSaldos = new JButton("Migración tabla Saldos");
		
		btnMigracionSaldos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblSaldo migracionTblSaldo = new MigracionTblSaldo();
				
				boolean finalizoOK = migracionTblSaldo.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionSaldos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblSaldo migracionTblSaldo = new MigracionTblSaldo();
					
					boolean finalizoOK = migracionTblSaldo.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
				
		btnMigracionSaldos.setBounds(24, 224, 246, 21);
		contentPane.add(btnMigracionSaldos);
		
		// Ayuda en Pesos
		
		JButton btnAyudaPesos = new JButton("Migración tabla Ayuda en Pesos");
		
		btnAyudaPesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblAyudaPesos migracionTblAyuda = new MigracionTblAyudaPesos();
				
				boolean finalizoOK = migracionTblAyuda.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnAyudaPesos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblAyudaPesos migracionTblAyuda = new MigracionTblAyudaPesos();
					
					boolean finalizoOK = migracionTblAyuda.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnAyudaPesos.setBounds(24, 255, 246, 21);
		contentPane.add(btnAyudaPesos);
		
		// Cuotas Ayuda en Pesos
		
		JButton btnCuotasAyudaPesos = new JButton("Migración Cuotas Ayuda en Pesos");
		
		btnCuotasAyudaPesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCuotaAyudaPesos migracionTblCuota = new MigracionTblCuotaAyudaPesos();
				
				boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnCuotasAyudaPesos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCuotaAyudaPesos migracionTblCuota = new MigracionTblCuotaAyudaPesos();
					
					boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnCuotasAyudaPesos.setBounds(24, 286, 246, 21);
		contentPane.add(btnCuotasAyudaPesos);
		
		// Cobros Cuotas Ayuda en Pesos
		
		JButton btnCobrosCuotasAyudaPesos = new JButton("Migración Cobros Ayuda en Pesos");
		
		btnCobrosCuotasAyudaPesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCobroCuotaAyudaPesos migracionTblCobroCuota = new MigracionTblCobroCuotaAyudaPesos();
				
				boolean finalizoOK = migracionTblCobroCuota.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnCobrosCuotasAyudaPesos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCobroCuotaAyudaPesos migracionTblCobroCuota = new MigracionTblCobroCuotaAyudaPesos();
					
					boolean finalizoOK = migracionTblCobroCuota.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
				
		btnCobrosCuotasAyudaPesos.setBounds(24, 317, 246, 21);
		contentPane.add(btnCobrosCuotasAyudaPesos);
		
		// Ayuda en Dolares
		
		JButton btnAyudaDolares = new JButton("Migración tabla Ayuda en Dolares");
		
		btnAyudaDolares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblAyudaDolares migracionTblAyuda = new MigracionTblAyudaDolares();
				
				boolean finalizoOK = migracionTblAyuda.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnAyudaDolares.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblAyudaDolares migracionTblAyuda = new MigracionTblAyudaDolares();
					
					boolean finalizoOK = migracionTblAyuda.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
				
		btnAyudaDolares.setBounds(24, 348, 246, 21);
		contentPane.add(btnAyudaDolares);
		
		// Cuotas Ayuda en Dolares
				
		JButton btnCuotasAyudaDolares = new JButton("Migración Cuotas Ayuda en Dolares");
		
		btnCuotasAyudaDolares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCuotaAyudaDolares migracionTblCuota = new MigracionTblCuotaAyudaDolares();
				
				boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnCuotasAyudaDolares.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCuotaAyudaDolares migracionTblCuota = new MigracionTblCuotaAyudaDolares();
					
					boolean finalizoOK = migracionTblCuota.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnCuotasAyudaDolares.setBounds(24, 379, 246, 21);
		contentPane.add(btnCuotasAyudaDolares);
		
		// Cobros Cuotas Ayuda en Dolares
		
		JButton btnCobrosCuotasAyudaDolares = new JButton("Migración Cobros Ayuda en Dolares");
		
		btnCobrosCuotasAyudaDolares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCobroCuotaAyudaDolares migracionTblCobroCuota = new MigracionTblCobroCuotaAyudaDolares();
				
				boolean finalizoOK = migracionTblCobroCuota.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnCobrosCuotasAyudaDolares.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCobroCuotaAyudaDolares migracionTblCobroCuota = new MigracionTblCobroCuotaAyudaDolares();
					
					boolean finalizoOK = migracionTblCobroCuota.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
				
		btnCobrosCuotasAyudaDolares.setBounds(24, 410, 246, 21);
		contentPane.add(btnCobrosCuotasAyudaDolares);
		
		// Parametro (TABLAS)
		
		JButton btnMigracionParametro = new JButton("Migración Parametro (TABLAS)");
		
		btnMigracionParametro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblParametro migracionTblParametro = new MigracionTblParametro();
				
				boolean finalizoOK = migracionTblParametro.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionParametro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblParametro migracionTblParametro = new MigracionTblParametro();
					
					boolean finalizoOK = migracionTblParametro.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionParametro.setBounds(312, 69, 246, 21);
		contentPane.add(btnMigracionParametro);
		
		// Garantia
		
		JButton btnMigracionGarantia = new JButton("Migración Garantía");
		
		btnMigracionGarantia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblGarantia migracionTblGarantia = new MigracionTblGarantia();
				
				boolean finalizoOK = migracionTblGarantia.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionGarantia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblGarantia migracionTblGarantia = new MigracionTblGarantia();
					
					boolean finalizoOK = migracionTblGarantia.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionGarantia.setBounds(312, 100, 246, 21);
		contentPane.add(btnMigracionGarantia);
		
		// Ayuda Frances
		
		JButton btnMigracionTblAyudaFrances = new JButton("Migración Ayuda Frances");
		
		btnMigracionTblAyudaFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblAyudaFrances migracionTblAyudaFrances = new MigracionTblAyudaFrances();
				
				boolean finalizoOK = migracionTblAyudaFrances.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionTblAyudaFrances.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblAyudaFrances migracionTblAyudaFrances = new MigracionTblAyudaFrances();
					
					boolean finalizoOK = migracionTblAyudaFrances.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionTblAyudaFrances.setBounds(312, 131, 246, 21);
		contentPane.add(btnMigracionTblAyudaFrances);
		
		// Cuotas Frances
		
		btnMigracionTblCuotaFrances = new JButton("Migración Cuotas Frances");
		
		btnMigracionTblCuotaFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCuotaAyudaFrances migracionTblCuotasFrances = new MigracionTblCuotaAyudaFrances();
				
				boolean finalizoOK = migracionTblCuotasFrances.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		
		btnMigracionTblCuotaFrances.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCuotaAyudaFrances migracionTblCuotasFrances = new MigracionTblCuotaAyudaFrances();
					
					boolean finalizoOK = migracionTblCuotasFrances.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionTblCuotaFrances.setBounds(312, 162, 246, 21);
		contentPane.add(btnMigracionTblCuotaFrances);
		
		// Cobros Frances
		
		JButton btnMigracionTblCobrosFrances = new JButton("Migración Cobros Frances");
		
		btnMigracionTblCobrosFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MigracionTblCobroCuotaAyudaFrances migracionTblCobrosFrances = new MigracionTblCobroCuotaAyudaFrances();
				
				boolean finalizoOK = migracionTblCobrosFrances.ejecutarProcesoMigracion();
				
				if (finalizoOK) {
		    		Utilidades.msg(null, "Migración completada correctamente");
		    	} else {
		    		Utilidades.msg(null, "Error en la Migración");
		    	}
				
			}
		});
		btnMigracionTblCobrosFrances.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == e.VK_ENTER) {
					
					MigracionTblCobroCuotaAyudaFrances migracionTblCobrosFrances = new MigracionTblCobroCuotaAyudaFrances();
					
					boolean finalizoOK = migracionTblCobrosFrances.ejecutarProcesoMigracion();
					
					if (finalizoOK) {
			    		Utilidades.msg(null, "Migración completada correctamente");
			    	} else {
			    		Utilidades.msg(null, "Error en la Migración");
			    	}
					
				}
				
			}
		});
		
		btnMigracionTblCobrosFrances.setBounds(312, 193, 246, 21);
		contentPane.add(btnMigracionTblCobrosFrances);
		
	}
}
