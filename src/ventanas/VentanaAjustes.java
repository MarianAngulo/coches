package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class VentanaAjustes extends JFrame {

	private JToolBar barra;
	
	public VentanaAjustes() {
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
		
		JLabel lblAjustes = new JLabel("Ajustes");
		lblAjustes.setBounds(205, 20, 133, 31);
		lblAjustes.setFont(new Font("Tahoma", Font.BOLD, 25));
		panelCentral.add(lblAjustes);
		
		JButton btnSobreNosotros = new JButton("Sobre nosotros");
		btnSobreNosotros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSobreNosotros.setBounds(150, 100, 200, 37);
		panelCentral.add(btnSobreNosotros);
		
		JButton btnCuenta = new JButton("Tu cuenta");
		btnCuenta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCuenta.setBounds(150, 180, 200, 37);
		panelCentral.add(btnCuenta);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCerrarSesion.setBounds(150, 260, 200, 37);
		panelCentral.add(btnCerrarSesion);
		
		JButton btnSalir = new JButton("Salir de la app");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(150, 340, 200, 37);
		panelCentral.add(btnSalir);
		
		bVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setSize(700,700);
				vp.setLocation(550, 150);
				vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vp.setLocationRelativeTo(null);
				vp.setVisible(true);
				dispose();
			}
		});
		
		btnSobreNosotros.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Creado por:\n- Miguel Solana\n- Xabier Gomez\n- Daniel Galean\n- Maria Angeles Angulo");
					}
				});
				
		btnCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCuenta vc = new VentanaCuenta(/*VentanaRegistro.u*/);
				vc.setSize(500, 600);
				vc.setLocation(550, 150);
				vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vc.setVisible(true);
				dispose();
			}
		});
		
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

		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
