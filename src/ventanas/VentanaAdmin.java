package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class VentanaAdmin extends JFrame{

	private JToolBar barra;
	
	public VentanaAdmin() {
		barra = new JToolBar();
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		panelSup.add(barra, BorderLayout.NORTH);
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelCentral = new JPanel();
		getContentPane().add( panelCentral, BorderLayout.CENTER );
		panelCentral.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Administrador");
		lblTitulo.setBounds(190, 50, 200, 31);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCentral.add(lblTitulo);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCerrarSesion.setBounds(175, 450, 200, 37);
		panelCentral.add(btnCerrarSesion);
		
		JButton btnGestionAlmacen = new JButton("Gestionar almacen");
		btnGestionAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionAlmacen.setBounds(50, 250, 200, 37);
		panelCentral.add(btnGestionAlmacen);
		
		JButton btnGestionUsuarios = new JButton("Gestionar usuarios");
		btnGestionUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionUsuarios.setBounds(300, 250, 200, 37);
		panelCentral.add(btnGestionUsuarios);
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro();
				vr.setSize(1000, 500);
				vr.setLocation(550, 150);
				vr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vr.setVisible(true);
				dispose();
			}
		});
		
		btnGestionAlmacen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAlmacen va = new VentanaAlmacen();
				va.setSize(600, 600);
				va.setLocation(550, 150);
				va.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				va.setVisible(true);
				dispose();
			}
		});

		btnGestionUsuarios.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaUsuarios vu = new VentanaUsuarios();
				vu.setSize(600, 600);
				vu.setLocation(550, 150);
				vu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vu.setVisible(true);
				dispose();
			}
		});
	}
}
