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
		
		panelSup.add(barra, BorderLayout.NORTH);
		add(panelSup);
		
		bRespuestos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRepuestos ventRes = new VentanaRepuestos();
				ventRes.setTitle("Repuestos");
				ventRes.setSize(700, 700);
				ventRes.setLocationRelativeTo(null);
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
		vent.setLocation(550, 300);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setResizable(false);
	}
	
}
