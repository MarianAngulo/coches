package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import clases.MarcaVehiculo;
import clases.Repuestos;
import clases.TipoVehiculo;
import clases.Vehiculo;


public class VentanaVehiculos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static List<Vehiculo> listvehiculos;
	private static VentanaVehiculos ventVe = new VentanaVehiculos();
	private static VentanaRegistro vr = new VentanaRegistro();
	private static ClaseContenedora cc = new ClaseContenedora();
	private DefaultTableModel modelo;
	private JTable tabla;
	private JToolBar botonesSup;
	private JToolBar botonesInf;
	
	int mouseRow = -1;
	int mouseCol = -1;
	

	
	
	public VentanaVehiculos() {
		
		
		listvehiculos= new ArrayList<Vehiculo>();
		
		leerCSV();
		initTabla();
		cargarVehiculos();
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle("Vehiculos");
		setSize(700, 700);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBorder(new TitledBorder("Vehiculos"));
		tabla.setFillsViewportHeight(true);
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
		
		TableCellRenderer renderMouseOver = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel label = new JLabel(value.toString());
			
			if (row == this.mouseRow && column == this.mouseCol) {
				label.setBackground(Color.YELLOW);
			} else {
				label.setBackground(table.getBackground());
			}
			
			if (isSelected) {
				label.setBackground(table.getSelectionBackground());
				label.setForeground(table.getSelectionForeground());
			}
			
			label.setOpaque(true);
				
			return label;
		};
		
		this.tabla.setDefaultRenderer(Object.class, renderMouseOver);
		
		
		this.tabla.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseRow = tabla.rowAtPoint(e.getPoint());
				mouseCol = tabla.columnAtPoint(e.getPoint());

				if (mouseRow > -1 && mouseCol >-1) {
					tabla.repaint();
				}
			}
		});
		
		JButton botoncomp = new JButton("Comprar");
		botonesSup.add(botoncomp);
		botoncomp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tabla.getSelectedRow() >= 0) {
					if (vr.usuarioLogged.getDinero() >= listvehiculos.get(tabla.getSelectedRow()).getPrecio()) {
						String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						cc.guardarDBVenta("Usuario.db", vr.usuarioLogged, listvehiculos.get(tabla.getSelectedRow()).getId(), listvehiculos.get(tabla.getSelectedRow()).getPrecio(), date);
						vr.usuarioLogged.setDinero(vr.usuarioLogged.getDinero()-listvehiculos.get(tabla.getSelectedRow()).getPrecio());
						} else {
						JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para realizar esta compra");
					}
				}
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
		
		JButton btnPosiblesCompras = new JButton("Posibles compras");
		botonesInf.add(btnPosiblesCompras);
		btnPosiblesCompras.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String resp = JOptionPane.showInputDialog(null, "¿Cuanto dinero quieres gastarte?:");
					if (resp==null) return;
					int dinero = Integer.parseInt( resp );
					calcularComprasPosibles( dinero );
				} catch (NumberFormatException e2) { }
			}
		});	
	}
	
	
	private void initTabla() {

		Vector<String> cabeceras = new Vector<String>(Arrays.asList( "ID", "TIPO", "MARCA", "MODELO","PRECIO", "IMAGEN"));
		modelo = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
		tabla = new JTable(modelo);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.getColumnModel().getColumn(5).setCellRenderer(renderImagen);
	}
	
	private void cargarVehiculos() {
		modelo.setRowCount(0);
		
		for (Vehiculo v : listvehiculos) {
			this.modelo.addRow( new Object[] {v.getId(), v.getTipo(), v.getMarca(), v.getModelo(), v.getPrecio(), v.getUrl()} );
		}		
	}
	
	
	public void leerCSV() {
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
	
	private void calcularComprasPosibles(int disponible) {
		ArrayList<Vehiculo> lVehiculos = new ArrayList<>();
		calcularComprasPosibles(listvehiculos, disponible, lVehiculos);
	}
	private void calcularComprasPosibles(List<Vehiculo> listvehiculos2, int restante, ArrayList<Vehiculo> lComprado) {
		if (restante < 0) return;
		else if (restante < 50) {
			System.out.println( "Posible compra (sobran " + String.format("%d",restante) + " euros): " + lComprado);
		}
		else {
			for (Vehiculo v : listvehiculos2) {
				lComprado.add(v);
				calcularComprasPosibles(listvehiculos2, restante - v.getPrecio(), lComprado);
				lComprado.remove(lComprado.size()-1);
			}
		}
	}
	
	public static void main(String args[]) {
		ventVe.setTitle("vehiculos");
		ventVe.setSize(700, 700);
		ventVe.setLocation(550, 150);
		ventVe.setVisible(true);
		ventVe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventVe.setResizable(false);
	}
	
	DefaultTableCellRenderer renderImagen = new DefaultTableCellRenderer() {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JLabel label = new JLabel();
			
			 for(Vehiculo v: listvehiculos) {
				 label.setIcon(new ImageIcon(v.getUrl()));
			 }
			 
			
			return label;
		}
	};
	
}
