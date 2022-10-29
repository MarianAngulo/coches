package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
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

public class VentanaRegistro extends JFrame {
	private static final long serialVersionUID = -6454706567318509276L;
	private JPanel panelcent;
	private JPanel panelcent2;
	private JLabel nuFoto;
	private JLabel huecoNombre;
	private JLabel huecoContrasena;
	private JTextField textoNombre;
	private JTextField textoContrasena;
	private JButton aceptar;
	private JButton cancelar;

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
		textoContrasena = new JTextField();
		
		aceptar = new JButton("Crear nuevo usuario");
		cancelar = new JButton("Cancelar");
		
		panelcent2.add(huecoNombre);
		panelcent2.add(textoNombre);
		panelcent2.add(huecoContrasena);
		panelcent2.add(textoContrasena);
		panelcent2.add(new JLabel());
		panelcent2.add(new JLabel());
		panelcent2.add(new JLabel());
		panelcent2.add(new JLabel());
		panelcent2.add(cancelar);
		panelcent2.add(aceptar);
		panelcent.add(nuFoto);
		panelcent.add(panelcent2);
		

		aceptar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent hg) {
				//ArrayList<Usuario> lista = cc.sacarUsuarios("Usuario.db"); IMPLEMENTAR
				if(textoNombre.getText().isBlank() || textoContrasena.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Por favor ponga el nombre de usuario que desea crear y/o su contraseña", "Crear usuario nuevo - Error", JOptionPane.INFORMATION_MESSAGE);
				}//UN ELSE IF QUE REVISE SI EL USUARIO EXISTE
				else {
					int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres crear un usuario con nombre: "+textoNombre.getText()+ " y contraseña: "+textoContrasena.getText()+"?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(opcion==0) {
						//cc.guardarDBUsuario("Usuario.db",1, 1, 0, textoNombre.getText(), textoContrasena.getText());
					}if(opcion==1) {
						
					}
				
				
			}
			}
		});
		
	
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Crear ventana de inicio de sesion normal
				
			}
		});
		add(panelcent);
	}
	
	public static void main(String args[]) {
		VentanaRegistro vent = new VentanaRegistro();
		vent.setTitle("Ventana para anyadir nuevo usuario");
		vent.setSize(1000, 500);
		vent.setLocation(550, 300);
		vent.setVisible( true );
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setResizable(false);
	}

}
