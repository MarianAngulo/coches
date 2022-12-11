package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import clases.Vehiculo;

public class VentanaVehiculos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Vehiculo> vehiculos;
	private static VentanaVehiculos ventVe;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JToolBar botonesSup;
	private JToolBar botonesInf;
	
	
	
	public VentanaVehiculos() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle("Vehiculos");
		setSize(700, 700);
		tabla = new JTable();
		botonesSup = new JToolBar();
		botonesInf = new JToolBar();
		getContentPane().add(tabla,BorderLayout.CENTER);
		getContentPane().add(botonesInf,BorderLayout.SOUTH);
		getContentPane().add(botonesSup,BorderLayout.NORTH);
		
		
		JButton botoncomp = new JButton("Comprar");
		botonesSup.add(botoncomp);
		botoncomp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton botonven = new JButton("Vender");
		botonesSup.add(botonven);
		botonven.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton botonv = new JButton("Volver");
		botonesInf.add(botonv);
		botonv.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setSize(700,700);
				vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vp.setLocationRelativeTo(null);
				vp.setVisible(true);
				dispose();
			}
		});	
		
	}
	
	
	
	
	private void visualizarVehiculos() {//Estructura de como se tendria que visualizar sin tener funcionalidad Base de datos
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Id", "Tipo", "Modelo", "Precio" ) );
		modelo = new DefaultTableModel( 
			new Vector<Vector<Object>>(),
			cabeceras 
		);
		//cargarVehiculos(); Faltaria esta funcionalidad
		for (Vehiculo v : vehiculos) {
			modelo.addRow( new Object[] { v.getId(), v.getTipo(), v.getModelo(), v.getPrecio(),  } );
		}
		tabla.setModel( modelo );
		
		tabla.getColumnModel().getColumn(0).setMinWidth(40);
		tabla.getColumnModel().getColumn(0).setMaxWidth(40);
		tabla.getColumnModel().getColumn(1).setMinWidth(80);
		tabla.getColumnModel().getColumn(1).setMaxWidth(80);
		tabla.getColumnModel().getColumn(3).setMinWidth(60);
		tabla.getColumnModel().getColumn(3).setMaxWidth(60);
	}
	
	
}
