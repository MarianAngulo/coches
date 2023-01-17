package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.*;

import ventanas.VentanaRepuestos;


public class VentanaPrincipal extends JFrame{
	private static VentanaPrincipal vent = new VentanaPrincipal();

	private JPanel panelSup;
	private JToolBar barra;
	
	public VentanaPrincipal() {
		ClaseContenedora cc = new ClaseContenedora();
		VentanaRegistro vr = new VentanaRegistro();
		panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		
		barra = new JToolBar();
		
		JButton bAjustes = new JButton("Ajustes");
		barra.add(bAjustes);
		
		
		JButton bVehi = new JButton("Vehiculos");
		barra.add(bVehi);
		
		bVehi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVehiculos ventVe = new VentanaVehiculos();
				ventVe.setLocationRelativeTo(null);
				ventVe.setVisible( true );
				ventVe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventVe.setResizable(false);
				dispose();	
			}
			
			
		});
		
		JButton bRespuestos = new JButton("Repuestos");
		barra.add(bRespuestos);
		
		JButton bInventario = new JButton("Inventario");
		barra.add(bInventario);
		
		/**bInventario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInventario ventI = new VentanaInventario();
				ventI.setLocationRelativeTo(null);
				ventI.setVisible( true );
				ventI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventI.setResizable(false);
				dispose();	
			}
			
			
		});**/
		
		
		panelSup.add(barra, BorderLayout.NORTH);
		add(panelSup);
		
		bRespuestos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRepuestos ventRes = new VentanaRepuestos();
				ventRes.setTitle("Repuestos");
				ventRes.setSize(700, 700);
				ventRes.setLocation(550, 150);
				ventRes.setVisible( true );
				ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventRes.setResizable(false);		
				dispose();
				
			}
		});
		
		bAjustes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes ventConfig = new VentanaAjustes();
				ventConfig.setTitle("Configuracion");
				ventConfig.setSize(500, 600);
				ventConfig.setLocation(550, 150);
				ventConfig.setLocationRelativeTo(null);
				ventConfig.setVisible( true );
				ventConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventConfig.setResizable(false);
				dispose();
			}
			
		});
	}
	
	public static void inicio() {
		VentanaPrincipal vent = new VentanaPrincipal();
		vent.setTitle("Ventana principal");
		vent.setSize(1000, 500);
		vent.setLocation(550, 150);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setResizable(false);
	}
	
}
