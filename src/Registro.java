import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Registro extends JFrame {
	
	public Registro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setTitle("Registro");
		JPanel Central = new JPanel();
		Central.setLayout(new GridLayout(4, 1));

		
		JTextField HuecoNombre = new JTextField();
		JTextField HuecoContraseña = new JTextField();
		JLabel Nombre = new JLabel("Usuario");
		JLabel Contraseña = new JLabel("Contraseña");
		JLabel Texto = new JLabel("Registro");
		JButton Entrar = new JButton("Entrar");
		
		Central.add(Nombre);
		Central.add(HuecoNombre);
		Central.add(Contraseña);
		Central.add(HuecoContraseña);
		Central.add(Entrar);
		
		add(Central);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Registro();
			}
		});
	}

}
