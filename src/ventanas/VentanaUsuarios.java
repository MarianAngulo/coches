package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import clases.Usuario;

public class VentanaUsuarios extends JFrame {
	private JToolBar barra;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public VentanaUsuarios() {
		barra = new JToolBar();
		
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		panelSup.add(barra, BorderLayout.NORTH);
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		JPanel panelCentral = new JPanel();
		getContentPane().add( panelCentral, BorderLayout.CENTER );
		panelCentral.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		barra.add(btnVolver);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAgregar.setBounds(50, 450, 200, 37);
		panelCentral.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBounds(300, 450, 200, 37);
		panelCentral.add(btnEliminar);

		JList listaUsuarios = new JList();
		listaUsuarios.setBounds(50, 54, 487, 234);
		panelCentral.add(listaUsuarios);
		
		/*
		JScrollPane scroll = new JScrollPane(listaUsuarios);
		panelCentral.add(scroll);
		*/
		
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
		
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Intruduzca un nombre de usuario");
				String con = JOptionPane.showInputDialog("Intruduzca una contraseña");
	
				if (name.isEmpty() || con.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios.");
				}
				//Confirmar que no existe un usuario con ese nombre
				
				//Guardarlo en la base de datos
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usuarios.remove(listaUsuarios.getSelectedIndex());
				//eliminar de la BD
				
				repaint();
			}
		});
	}
}