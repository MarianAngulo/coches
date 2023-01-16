package ventanas;

import java.awt.BorderLayout;
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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Repuestos;
import clases.TipoRepuesto;


public class VentanaRepuestos extends JFrame {

	private JToolBar barra;
	private JToolBar barraAbajo;
	private static List<Repuestos> repuestos;
	private JTable tablaRepuestos;
	private DefaultTableModel modeloDatosRepuestos;
	
	private static VentanaRepuestos ventRes = new VentanaRepuestos(repuestos);
	
	
	public VentanaRepuestos(List<Repuestos> repuestos) {
		
		repuestos = new ArrayList<Repuestos>();
		this.repuestos = repuestos;
		
		/**Repuestos r= new Repuestos(1,TipoRepuesto.MOTOR,12.0f,12.0f);
		repuestos.add(r);**/
		
		this.leerCSV();
		this.iniciarTabla();
		this.cargarRepuestos();
		
		JScrollPane scrollPaneRepuestos = new JScrollPane(this.tablaRepuestos);
		scrollPaneRepuestos.setBorder(new TitledBorder("Repuestos"));
		this.tablaRepuestos.setFillsViewportHeight(true);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(scrollPaneRepuestos);
		
		barra = new JToolBar();
		barraAbajo = new JToolBar();
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		getContentPane().add( panelSouth, BorderLayout.SOUTH );
		
		
		JButton volver = new JButton("Volver");
		JButton comprar = new JButton("Comprar");
		JButton vender = new JButton("Vender");
		JButton anyadirCSV = new JButton("importar repuestos (archivos locales)");
		barra.add(comprar);
		barra.add(vender);
		barraAbajo.add(volver);
		barraAbajo.add(anyadirCSV);
		
	
		panelSup.add(barra, BorderLayout.NORTH);
		panelSouth.add(barraAbajo, BorderLayout.SOUTH);
		panelSup.add(scrollPaneRepuestos, BorderLayout.CENTER);
		
		
		
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventRes.setVisible( false );
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setSize(700,700);
				vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vp.setLocationRelativeTo(null);
				vp.setVisible(true);
				dispose();
				
			}
		});
	}
	
	
	private void iniciarTabla() {

		Vector<String> cabeceraComics = new Vector<String>(Arrays.asList("ID", "Tipo", "Compra", "Venta"));
		this.modeloDatosRepuestos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraComics);
		this.tablaRepuestos = new JTable(this.modeloDatosRepuestos);
		this.tablaRepuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void cargarRepuestos() {
		this.modeloDatosRepuestos.setRowCount(0);
		
		for (Repuestos c : this.repuestos) {
			this.modeloDatosRepuestos.addRow( new Object[] {c.getId(), c.getTipo(), c.getCompra(), c.getVenta()} );
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
				
				Repuestos r = new Repuestos(id,motor,compra,venta);
				repuestos.add(r);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	

	public static void main(String args[]) {
		ventRes.setTitle("repuestos");
		ventRes.setSize(700, 700);
		ventRes.setLocation(550, 150);
		ventRes.setVisible(true);
		ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventRes.setResizable(false);
	}
}