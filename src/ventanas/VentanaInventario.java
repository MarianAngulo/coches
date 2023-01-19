package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.MarcaVehiculo;
import clases.Repuestos;
import clases.TipoVehiculo;
import clases.Vehiculo;


public class VentanaInventario extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static List<Vehiculo> listvehiculosUsu;
	private static List<Repuestos> repuestosUsu;
	private static VentanaInventario ventVe = new VentanaInventario();
	private JTable tablaRepuestos;
	private DefaultTableModel modeloDatosRepuestos;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JToolBar botonesSup;
	private JToolBar botonesInf;
	
	
	
	public VentanaInventario() {	
		repuestosUsu = new ArrayList<Repuestos>();
		listvehiculosUsu = new ArrayList<Vehiculo>();
		VentanaRegistro vr = new VentanaRegistro();
		VentanaVehiculos vv = new VentanaVehiculos();
		VentanaRepuestos vp = new VentanaRepuestos();
		ClaseContenedora cc = new ClaseContenedora();

		initTablaRepuestos();
		
		for (Vehiculo v: vv.listvehiculos) {
			 for (int i = 0; i< cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).size(); i++) {
				if (cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).get(i) == v.getId()) {
					listvehiculosUsu.add(v);
				}
			}
		}
		
		for (Repuestos r: vp.repuestos) {
			 for (int i = 0; i< cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).size(); i++) {
				if (cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).get(i) == r.getId()) {
					repuestosUsu.add(r);
				}
			}
		}
		
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle("Inventario");
		setSize(700, 700);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(new TitledBorder("Inventario"));
		this.tabla.setFillsViewportHeight(true);
		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(scrollPane);
		botonesSup = new JToolBar();
		botonesInf = new JToolBar();
	
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelInf = new JPanel();
		panelInf.setLayout(new BorderLayout());
		getContentPane().add( panelInf, BorderLayout.SOUTH );
		
		panelSup.add(scrollPane,BorderLayout.CENTER);
		panelInf.add(botonesInf,BorderLayout.SOUTH);
		panelSup.add(botonesSup,BorderLayout.NORTH);
		
		JButton botoncomp = new JButton("Vehiculos");
		botonesSup.add(botoncomp);
		botoncomp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarVehiculos();
				initTablaVehiculos();
				repaint();
			}
		});
		
		JButton botonven = new JButton("Repuestos");
		botonesSup.add(botonven);
		botonven.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarRepuestos();
				initTablaRepuestos();
				repaint();
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
	
	
	private void initTablaVehiculos() {
		Vector<String> cabeceras = new Vector<String>(Arrays.asList( "ID", "TIPO", "MARCA", "MODELO","PRECIO", "IMAGEN"));
		this.modelo = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
		this.tabla = new JTable(this.modelo);
		this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	
	private void initTablaRepuestos() {

		Vector<String> cabeceraComics = new Vector<String>(Arrays.asList("ID", "Tipo", "Compra", "Venta"));
		this.modelo = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraComics);
		this.tabla = new JTable(this.modelo);
		this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void cargarVehiculos() {

		for (Vehiculo v : listvehiculosUsu) {
			this.modelo.addRow( new Object[] {v.getId(), v.getTipo(), v.getMarca(), v.getModelo(), v.getPrecio(), v.getUrl()} );
		}		
	}
	
	private void cargarRepuestos() {

		for (Repuestos c : repuestosUsu) {
			this.modelo.addRow( new Object[] {c.getId(), c.getTipo(), c.getCompra(), c.getVenta()} );
		}		
	}
	
	/**public static void main(String args[]) {
		ventVe.setTitle("inventario");
		ventVe.setSize(700, 700);
		ventVe.setLocation(550, 150);
		ventVe.setVisible(true);
		ventVe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventVe.setResizable(false);
	}
	
	**/
}
