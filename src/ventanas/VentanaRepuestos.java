package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bd.BD;
import clases.Repuestos;
import clases.TipoRepuesto;
import clases.Vehiculo;


public class VentanaRepuestos extends JFrame {

	private JToolBar barra;
	private JToolBar barraAbajo;
	static List<Repuestos> repuestos;
	private JTable tablaRepuestos;
	private DefaultTableModel modeloDatosRepuestos;
	//private JLabel lFoto;

	
	
	public VentanaRepuestos() {
		//BD.leerCSVRepuestos("repuestos");
		VentanaRegistro vr = new VentanaRegistro();
		ClaseContenedora cc = new ClaseContenedora();
		
		
		
		//System.out.println(vr.usuarioLogged.getListaRepuestos());
		
		repuestos = new ArrayList<Repuestos>();		
		
		leerCSV();
		iniciarTabla();
		cargarRepuestos();
		
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
		
		/**JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		getContentPane().add( panelCentro, BorderLayout.CENTER );**/
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		getContentPane().add( panelSouth, BorderLayout.SOUTH );
		
		
		JButton volver = new JButton("Volver");
		JButton comprar = new JButton("Comprar");
		JButton vender = new JButton("Vender");
		
		barra.add(comprar);
		barra.add(vender);
		barraAbajo.add(volver);
		
		//lFoto = new JLabel();
	
		panelSup.add(barra, BorderLayout.NORTH);
		panelSouth.add(barraAbajo, BorderLayout.SOUTH);
		//panelCentro.add(lFoto, BorderLayout.CENTER);
		panelSup.add(scrollPaneRepuestos, BorderLayout.CENTER);
		
		//lFoto.setPreferredSize( new Dimension( 200, 200 ) );
		
		/**tablaRepuestos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (tablaRepuestos.getSelectedRow() >= 0 && tablaRepuestos.getSelectedRow() < repuestos.size()) {
						String urlFoto = repuestos.get(tablaRepuestos.getSelectedRow()).getUrl();
						System.out.println(urlFoto);
						refrescaFoto( urlFoto );
					} else {
						refrescaFoto( null );
					}
					
				}
				
			}
		});**/
		
		comprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablaRepuestos.getSelectedRow() >= 0) {
					if (vr.usuarioLogged.getDinero() >= repuestos.get(tablaRepuestos.getSelectedRow()).getVenta()) {
						String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						cc.guardarDBVenta("Usuario.db", vr.usuarioLogged, repuestos.get(tablaRepuestos.getSelectedRow()).getId(), repuestos.get(tablaRepuestos.getSelectedRow()).getVenta(), date);
						vr.usuarioLogged.setDinero(vr.usuarioLogged.getDinero()-repuestos.get(tablaRepuestos.getSelectedRow()).getVenta());
						} else {
						JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para realizar esta compra");
					}
				}

				
			}
		});
		/**
		vender.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tablaRepuestos.getSelectedRow() >= 0) {
					for (Repuestos r: repuestos) {
						for (int i = 0; i< cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).size(); i++) {
							if (cc.sacarIdsUsuario("Usuario.db", vr.usuarioLogged).get(i) == r.getId()) {
									if (r.getId() == repuestos.get(tablaRepuestos.getSelectedRow()).getId()) {
										String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
										cc.guardarDBVenta("Usuario.db", vr.usuarioLogged, repuestos.get(tablaRepuestos.getSelectedRow()).getId(), -repuestos.get(tablaRepuestos.getSelectedRow()).getVenta(), date);						
										vr.usuarioLogged.setDinero(vr.usuarioLogged.getDinero()+repuestos.get(tablaRepuestos.getSelectedRow()).getCompra());
								}
							}
						}
					}
				}

				
			}
		});**/
		
		volver.addActionListener(new ActionListener() {

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
		barraAbajo.add(btnPosiblesCompras);
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
	
	
	// Refresca la foto 
	/**private void refrescaFoto( String url ) {
		if (url==null) {
			lFoto.setIcon( null );
			lFoto.repaint();
		} else {
			try {
			Image img = ImageIO.read(getClass().getResource(url));
			lFoto.setIcon(new ImageIcon(img));
			} catch (Exception ex) {
				System.out.println(ex);
				}
			lFoto.repaint();
		}
	}**/
	
	private void iniciarTabla() {

		Vector<String> cabeceraRepuestos = new Vector<String>(Arrays.asList("ID", "Tipo", "Compra", "Venta"));
		this.modeloDatosRepuestos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraRepuestos);
		this.tablaRepuestos = new JTable(this.modeloDatosRepuestos);
		this.tablaRepuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void cargarRepuestos() {
		this.modeloDatosRepuestos.setRowCount(0);
		
		for (Repuestos c : repuestos) {
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
	
	private void calcularComprasPosibles(int disponible) {
		ArrayList<Repuestos> lVehiculos = new ArrayList<>();
		calcularComprasPosibles(repuestos, disponible, lVehiculos);
	}
	private void calcularComprasPosibles(List<Repuestos> list, int restante, ArrayList<Repuestos> lComprado) {
		if (restante < 0) return;
		else if (restante < 50) {
			System.out.println( "Posible compra (sobran " + String.format("%d",restante) + " euros): " + lComprado);
		}
		else {
			for (Repuestos r : list) {
				lComprado.add(r);
				calcularComprasPosibles(list, restante - r.getCompra(), lComprado);
				lComprado.remove(lComprado.size()-1);
			}
		}
	}
	
	public static void main(String args[]) {
		VentanaRegistro ventRes = new VentanaRegistro();
		ventRes.setTitle("repuestos");
		ventRes.setSize(700, 700);
		ventRes.setLocation(550, 150);
		ventRes.setVisible(true);
		ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventRes.setResizable(false);
	}
}
