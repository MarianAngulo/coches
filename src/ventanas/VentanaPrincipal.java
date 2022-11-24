package ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.*;


public class VentanaPrincipal extends JFrame{

	private JPanel panelSup;
	private JToolBar barra;
	
	public VentanaPrincipal() {
		panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		
		barra = new JToolBar();
		
		JButton bConfiguracion = new JButton("Configuracion");
		barra.add(bConfiguracion);
		
		JButton bCoches = new JButton("Coches");
		barra.add(bCoches);
		
		JButton bRespuestos = new JButton("Repuestos");
		barra.add(bRespuestos);
		
		panelSup.add(barra, BorderLayout.NORTH);
		add(panelSup);
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
