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
		
		JButton bCoches = new JButton("Coches");
		barra.add(bCoches);
		
		JButton bRespuestos = new JButton("Repuestos");
		barra.add(bRespuestos);
		
		panelSup.add(barra, BorderLayout.NORTH);
		add(panelSup);
		
		bRespuestos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vent.setVisible( false );
				VentanaRepuestos ventRes = new VentanaRepuestos();
				ventRes.setTitle("Repuestos");
				ventRes.setSize(700, 700);
				ventRes.setLocation(0, 0);
				ventRes.setVisible( true );
				ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventRes.setResizable(false);
				dispose();
				
				
			}
		});
		
		bAjustes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vent.setVisible( false );
				VentanaAjustes ventConfig = new VentanaAjustes();
				ventConfig.setTitle("Configuracion");
				ventConfig.setSize(500, 600);
				ventConfig.setLocation(0, 0);
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
