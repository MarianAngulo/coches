package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clases.Usuario;

public class VentanaUsuarios extends JFrame {
	private JToolBar barra;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private JTable tDatos;
	private DefaultTableModel mDatos;
	
	private JPanel panelSup;
	private JPanel panelCentral;
	
	private JButton btnVolver;
	private JButton btnAgregar;
	private JButton btnEliminar;
	
	private JTable table;
	
	
	public VentanaUsuarios() {
		ClaseContenedora cc = new ClaseContenedora();
		usuarios = cc.sacarUsuarios("Usuario.db");
		barra = new JToolBar();
		
		panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		panelSup.add(barra, BorderLayout.NORTH);
		getContentPane().add( panelSup, BorderLayout.NORTH );
		
		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		
		btnVolver = new JButton("Volver");
		barra.add(btnVolver);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAgregar.setBounds(50, 450, 200, 37);
		panelCentral.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBounds(300, 450, 200, 37);
		panelCentral.add(btnEliminar);
		

		String col[] = {"Nombre","Dinero", "Admin"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (int i = 0; i<usuarios.size(); i++) {
			String nombre = usuarios.get(i).getNombre();
			int dinero = usuarios.get(i).getDinero();
			String admin = "";
			if (usuarios.get(i).getAdmin() == 1) {admin = "Admin";}
			else {admin = "Usuario";}
			
			 Object[] data = {nombre, dinero + "�", admin};
			 
			 tableModel.addRow(data);
		}

		
		table = new JTable(tableModel);
		table.setBounds(36, 10, 345, 200);
		
		panelCentral.add(table);
		
		getContentPane().add( panelCentral, BorderLayout.CENTER );
		
		
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
				//Confirmar que no existe un usuario con ese nombre y guardarlo en la bbdd
				if (cc.buscarUsuarioPorNombre("Usuario.db", name) == null) {
					cc.guardarDBUsuario("Usuario.db", name.toString(), con.toString(), 0, 0);
					
					VentanaUsuarios vu = new VentanaUsuarios();
					vu.setSize(600, 600);
					vu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					vu.setVisible(true);
					dispose();
				}
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					if (usuarios.get(table.getSelectedRow()).getAdmin() == 1) {
						JOptionPane.showMessageDialog(null, "No puedes eliminar a otro administrador.");
					}else {	
							//eliminar de la BD
							cc.borrarDBUsuario("Usuario.db", usuarios.get(table.getSelectedRow()).getNombre());
							usuarios.remove(table.getSelectedRow());
							
							VentanaUsuarios vu = new VentanaUsuarios();
							vu.setSize(600, 600);
							vu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							vu.setVisible(true);
							dispose();
					}
				}
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