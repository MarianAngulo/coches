package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.MarcaVehiculo;
import clases.Repuestos;
import clases.TipoRepuesto;
import clases.TipoVehiculo;
import clases.Vehiculo;
import ventanas.VentanaRepuestos;
import ventanas.VentanaVehiculos;

public class VentanaAlmacen extends JFrame {
	private JToolBar barra;
	static List<Repuestos> repuestos;
	static List<Vehiculo> listvehiculos;
	private JTable tablaRepuestos;
	private JTable tabla;
	private DefaultTableModel modeloDatosRepuestos;
	private DefaultTableModel modelo;
	private JLabel lFoto;
	static VentanaVehiculos ventVe = new VentanaVehiculos();
	
	public VentanaAlmacen() {
		
		VentanaRepuestos vc = new VentanaRepuestos();
		VentanaVehiculos vv = new VentanaVehiculos();
		VentanaRegistro vr = new VentanaRegistro();
		ClaseContenedora cc = new ClaseContenedora();
		
		repuestos = new ArrayList<Repuestos>();	
		listvehiculos= new ArrayList<Vehiculo>();
		
		leerCSV();
		leerCSVCoches();
		iniciarTabla();
		initTabla();
		cargarRepuestos();
		cargarVehiculos();
		
		JScrollPane scrollPaneRepuestos = new JScrollPane(this.tablaRepuestos);
		scrollPaneRepuestos.setBorder(new TitledBorder("Repuestos"));
		this.tablaRepuestos.setFillsViewportHeight(true);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(scrollPaneRepuestos);
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(new TitledBorder("Vehiculos"));
		tabla.setFillsViewportHeight(true);
		getContentPane().setLayout(new GridLayout(2, 1));
		getContentPane().add(scrollPane);
		
		barra = new JToolBar();
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelSup2 = new JPanel();
		panelSup2.setLayout(new BorderLayout());
		getContentPane().add( panelSup2, BorderLayout.CENTER );
		
		JPanel panelbarra = new JPanel();
		panelbarra.setLayout(new BorderLayout());
		getContentPane().add( panelbarra, BorderLayout.SOUTH );
		
		JButton btnVolver = new JButton("Volver");
		JButton btnBorrar = new JButton("Borrar");
		JButton btnAnyadir = new JButton("Anyadir");
		barra.add(btnVolver);
		barra.add(btnBorrar);
		barra.add(btnAnyadir);
		
		panelSup2.add(scrollPane,BorderLayout.CENTER);
		panelSup.add(scrollPaneRepuestos, BorderLayout.CENTER);
		panelbarra.add(barra, BorderLayout.SOUTH);
		
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va = new VentanaAdmin();
				va.setSize(600, 600);
				va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				va.setVisible(true);
				dispose();
			}
		});
		
		
		
	}
	
	private void iniciarTabla() {

		Vector<String> cabeceraRepuestos = new Vector<String>(Arrays.asList("ID", "Tipo", "Compra", "Venta"));
		this.modeloDatosRepuestos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraRepuestos);
		this.tablaRepuestos = new JTable(this.modeloDatosRepuestos);
		this.tablaRepuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void initTabla() {

		Vector<String> cabeceras = new Vector<String>(Arrays.asList( "ID", "TIPO", "MARCA", "MODELO","PRECIO", "IMAGEN"));
		modelo = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
		tabla = new JTable(modelo);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void cargarRepuestos() {
		this.modeloDatosRepuestos.setRowCount(0);
		
		for (Repuestos c : repuestos) {
			this.modeloDatosRepuestos.addRow( new Object[] {c.getId(), c.getTipo(), c.getCompra(), c.getVenta()} );
		}		
	}
	
	private void cargarVehiculos() {
		modelo.setRowCount(0);
		
		for (Vehiculo v : listvehiculos) {
			this.modelo.addRow( new Object[] {v.getId(), v.getTipo(), v.getMarca(), v.getModelo(), v.getPrecio(), v.getUrl()} );
		}		
	}
	
	
	public void leerCSV() {
		String path = "data/repuestos.csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
			
				TipoRepuesto motor = TipoRepuesto.valueOf(values[0]);
				int id = Integer.parseInt(values[1]);
				int compra = Integer.parseInt(values[2]);
				int venta = Integer.parseInt(values[3]);
				String url = values[4];
				
				Repuestos r = new Repuestos(id,motor,compra,venta, url);
				repuestos.add(r);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void leerCSVCoches() {
		String path = "data/vehiculos.csv";
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
			
				TipoVehiculo tipo = TipoVehiculo.valueOf(values[0]);
				String modeloVeh = values[1];
				MarcaVehiculo marca = MarcaVehiculo.valueOf(values[2]);
				int id = Integer.parseInt(values[3]);
				int precio = Integer.parseInt(values[4]);
				String url = values[5];
				
				
				Vehiculo v = new Vehiculo(tipo,marca, modeloVeh, id, precio, url);
				listvehiculos.add(v);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		} 
	}
}
