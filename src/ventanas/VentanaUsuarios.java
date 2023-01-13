package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;

public class VentanaUsuarios extends JFrame {
	private JToolBar barra;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private JTable tDatos;
	private DefaultTableModel mDatos;
	
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
		//panelCentral.add(listaUsuarios);
		
		/*
		JScrollPane scroll = new JScrollPane(listaUsuarios);
		panelCentral.add(scroll);
		*/
		
		tDatos = new JTable();
		getContentPane().add( new JScrollPane(tDatos), BorderLayout.CENTER );
		
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
	
	private void verUsuarios() {
		Vector<String> cabeceras = new Vector<String>( Arrays.asList( "Nombre", "Contraseña", "Admin" ) );
		mDatos = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceras);
		
		//ArrayList<Usuario> usuarios = BaseDatos.getCompras( listaUsuarios ); //implementacion bd
		for (Usuario u : usuarios) {
			mDatos.addRow( new Object[] { u.getNombre(), u.getContrasena(), u.getAdmin()} );
		}
		tDatos.setModel( mDatos );
	}
}