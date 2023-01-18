package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import clases.Repuestos;
import clases.TipoRepuesto;

public class VentanaAnyadir extends JFrame{

	private JToolBar barra;
	
	public VentanaAnyadir() {
	
		barra = new JToolBar();
		
		JButton bVolver = new JButton("Volver");
		barra.add(bVolver);
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		panelSup.add(barra, BorderLayout.NORTH);
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelCentral = new JPanel();
		getContentPane().add( panelCentral, BorderLayout.CENTER );
		panelCentral.setLayout(null);
		
		JButton añadirRep = new JButton("Añadir repuesto");
		añadirRep.setFont(new Font("Tahoma", Font.PLAIN, 17));
		añadirRep.setBounds(150, 340, 200, 37);
		panelCentral.add(añadirRep);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblID.setBounds(100, 50, 96, 14);
		panelCentral.add(lblID);
		
		JTextField textID = new JTextField();
		textID.setEditable(true);
		textID.setBounds(250, 50, 96, 20);
		panelCentral.add(textID);
		
		JLabel lbltipo = new JLabel("tipo");
		lbltipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltipo.setBounds(100, 100, 96, 14);
		panelCentral.add(lbltipo);
		
		JComboBox textNombre = new JComboBox();
		textNombre.setEditable(true);
		textNombre.setBounds(250, 100, 96, 20);
		panelCentral.add(textNombre);
		
		textNombre.addItem("MOTOR");
		textNombre.addItem("TRANSMISION");
		textNombre.addItem("NEUMATICO");
		textNombre.addItem("TUBO_DE_ESCAPE");
		textNombre.addItem("CAJA_DE_CAMBIOS");
		textNombre.addItem("PARABRISAS");
		
		JLabel lblcompra = new JLabel("compra");
		lblcompra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcompra.setBounds(100, 150, 96, 14);
		panelCentral.add(lblcompra);
		
		JTextField textCompra = new JTextField();
		textCompra.setEditable(true);
		textCompra.setBounds(250, 150, 96, 20);
		panelCentral.add(textCompra);

		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVenta.setBounds(100, 200, 96, 14);
		panelCentral.add(lblVenta);
		
		JTextField textVenta = new JTextField();
		textVenta.setEditable(true);
		textVenta.setBounds(250, 200, 96, 20);
		panelCentral.add(textVenta);
		
		JLabel lblURL = new JLabel("URL imagen");
		lblURL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblURL.setBounds(100, 250, 96, 14);
		panelCentral.add(lblURL);
		
		JTextField textURL = new JTextField();
		textURL.setEditable(true);
		textURL.setBounds(250, 250, 96, 20);
		panelCentral.add(textURL);
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin va = new VentanaAdmin();
				va.setSize(600,600);
				va.setLocation(550, 150);
				va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				va.setVisible(true);
				dispose();
			}
		});
		
		añadirRep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String line = "";
				
				String id = textID.getText();
				TipoRepuesto tipo = TipoRepuesto.valueOf(textNombre.getSelectedItem().toString());
				String compra = textCompra.getText();
				String venta = textVenta.getText();
				String url = textURL.getText();
				
				ArrayList<String> value = new ArrayList<String>();
				value.add(id);
				value.add(tipo.toString());
				value.add(compra);
				value.add(venta);
				value.add(url);
				
				//System.out.println(value);
				
				
				
			}
		});
		
	}
}
