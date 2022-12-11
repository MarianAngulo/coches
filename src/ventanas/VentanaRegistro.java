package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.Usuario;
import ventanas.VentanaPrincipal;

public class VentanaRegistro extends JFrame {
	private static VentanaRegistro vent = new VentanaRegistro();
	
	private static final long serialVersionUID = -6454706567318509276L;
	private JPanel panelcent;
	private JPanel panelcent2;
	private JLabel nuFoto;
	private JLabel huecoNombre;
	private JLabel huecoContrasena;
	private JTextField textoNombre;
	private JPasswordField textoContrasena;
	private JButton registrase;
	private JButton iniciarSesion;
	private JButton salir;

	public VentanaRegistro() {
		ClaseContenedora cc = new ClaseContenedora();
		panelcent = new JPanel();
		panelcent.setLayout(new GridLayout(1,2));
		panelcent2 = new JPanel();
		panelcent2.setLayout(new GridLayout(5,2));
		nuFoto = new JLabel();
		try {
		    Image img = ImageIO.read(getClass().getResource("fotoempre.jpg"));
		    nuFoto.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		}		
		huecoNombre = new JLabel("Nombre de Usuario: ");
		huecoContrasena = new JLabel("Contraseña: ");
		textoNombre = new JTextField();
		textoContrasena = new JPasswordField();
		
		registrase = new JButton("Crear nuevo usuario");
		iniciarSesion = new JButton("Iniciar Sesion");
		
		panelcent2.add(huecoNombre);
		panelcent2.add(textoNombre);
		panelcent2.add(huecoContrasena);
		panelcent2.add(textoContrasena);
		panelcent2.add(new JLabel());
		panelcent2.add(new JLabel());
		panelcent2.add(iniciarSesion);
		panelcent2.add(registrase);
		panelcent.add(nuFoto);
		panelcent.add(panelcent2);
		salir = new JButton("Salir");
		panelcent2.add(salir);
		
	
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vent.setVisible( false );
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setSize(700,700);
				vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vp.setVisible(true);
				dispose();
				
				
			}
		});
		

		registrase.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent hg) {
				ArrayList<Usuario> lista = cc.sacarUsuarios("Usuario.db");
				if(textoNombre.getText().isBlank() || textoContrasena.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Por favor ponga el nombre de usuario que desea crear y/o su contraseña", "Crear usuario nuevo - Error", JOptionPane.INFORMATION_MESSAGE);
				}else if (lista.contains(textoNombre.getText())){
					JOptionPane.showMessageDialog(null, "Este usuario ya existe", "Crear usuario nuevo - Error", JOptionPane.INFORMATION_MESSAGE);					
				}
				else {
					int opcion = JOptionPane.showConfirmDialog(null, "�Estas seguro de que quieres crear un usuario con nombre: "+textoNombre.getText()+ " y contrase�a: "+textoContrasena.getText()+"?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(opcion==0) {
						cc.guardarDBUsuario("Usuario.db",textoNombre.getText(), textoContrasena.getText(), 0, 0);
					}if(opcion==1) {
						
					}
							
			}
				
			}
		});
		getContentPane().add(panelcent);
	}
	
	public static void main(String args[]) {
		vent.setTitle("Ventana para anyadir nuevo usuario");
		vent.setSize(1000, 500);
		vent.setVisible( true );
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setResizable(false);
	}

}
