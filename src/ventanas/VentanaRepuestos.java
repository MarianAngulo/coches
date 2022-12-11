package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import clases.Repuestos;

public class VentanaRepuestos extends JFrame {
	private static VentanaRepuestos ventRes = new VentanaRepuestos();

	private JToolBar barra;
	private JToolBar barraAbajo;
	
	private DefaultTableModel imagenes = new DefaultTableModel(new Object[] { "ID ", "compra", "venta" }, 0);
	private JTable tablaImagenes = new JTable( imagenes );
	
	private DefaultListModel<Repuestos> ListaRepuestos = new DefaultListModel<>();
	private JList<Repuestos> tablaRepuestos = new JList<>( ListaRepuestos );
	
	
	
	public VentanaRepuestos() {
		
		barra = new JToolBar();
		barraAbajo = new JToolBar();
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelEast = new JPanel();
		panelEast.setLayout(new BorderLayout());
		getContentPane().add( panelEast, BorderLayout.EAST );
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		getContentPane().add( panelSouth, BorderLayout.SOUTH );
		
		
		JButton volver = new JButton("Volver");
		JButton comprar = new JButton("Comprar");
		JButton vender = new JButton("Vender");
		barra.add(comprar);
		barra.add(vender);
		barraAbajo.add(volver);
	
		
		panelSup.add(barra, BorderLayout.NORTH);
		panelSouth.add(barraAbajo, BorderLayout.NORTH);
		panelEast.add(tablaImagenes, BorderLayout.EAST);
		panelEast.add( new JLabel( "Fotos:" ), BorderLayout.NORTH );
		panelSup.add(tablaRepuestos, BorderLayout.WEST);
		
		
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
	
	

	public static void main(String args[]) {
		ventRes.setTitle("repuestos");
		ventRes.setSize(700, 700);
		ventRes.setLocation(550, 300);
		ventRes.setVisible(true);
		ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventRes.setResizable(false);
	}
}
