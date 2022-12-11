package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import clases.Usuario;

public class VentanaCuenta extends JFrame{
	
	private JToolBar barra;
	
	public VentanaCuenta(/*Usuario u*/) {
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
		
		JButton btnBorrar = new JButton("Borrar la cuenta");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBorrar.setBounds(150, 340, 200, 37);
		panelCentral.add(btnBorrar);
		
		JButton btnContrasena = new JButton("Cambiar contraseña");
		btnContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnContrasena.setBounds(150, 280, 200, 37);
		panelCentral.add(btnContrasena);
		
		JLabel lblCuenta = new JLabel("Tu cuenta");
		lblCuenta.setBounds(180, 20, 133, 31);
		lblCuenta.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCentral.add(lblCuenta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(100, 100, 96, 14);
		panelCentral.add(lblNombre);
		JTextField textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(250, 100, 96, 14);
		panelCentral.add(textNombre);
		//textNombre.setText(u.getNombre()); --> cuando funcione la BD
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasena.setBounds(100, 150, 96, 14);
		panelCentral.add(lblContrasena);
		JTextField textContrasena = new JTextField();
		textContrasena.setEditable(false);
		textContrasena.setBounds(250, 150, 96, 14);
		panelCentral.add(textContrasena);
		//textContrasena.setText(u.getContrasena()); --> cuando funcione la BD
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDinero.setBounds(100, 200, 96, 14);
		panelCentral.add(lblDinero);
		JTextField textDinero = new JTextField();
		textDinero.setEditable(false);
		textDinero.setBounds(250, 200, 96, 14);
		panelCentral.add(textDinero);
		//textDinero.setText(u.getDinero()); --> cuando funcione la BD
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setSize(500,600);
				va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				va.setVisible(true);
				dispose();
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//FALTA FUNCIONALIDAD BD
				//te devuelve a la ventana registro
				VentanaRegistro vr = new VentanaRegistro();
				vr.setSize(1000, 500);
				vr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vr.setVisible(true);
				dispose();
			}
		});
		
		btnContrasena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//FALTA FUNCIONALIDAD BD
				//te devuelve a la ventana registro
				int result = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cambiar tu contrasena?");

		        if (result == 0) {
		        	System.out.println("You pressed Yes");
		        	String newContrasena = JOptionPane.showInputDialog(null, "Introduzca su nueva contrasena:");
		        	//funcionalidad BD
		        	System.out.println("Su nueva contrasena es: "+newContrasena);
		        	textContrasena.setText(newContrasena);
		        }  
		        else
		            System.out.println("You pressed NO");
			}
		});
	}
}
