package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class VentanaRepuestos extends JFrame {
	private static VentanaRepuestos ventRes = new VentanaRepuestos();

	private JPanel panelSup;
	private JToolBar barra;
	
	public VentanaRepuestos() {
		panelSup = new JPanel();
		panelSup.setLayout(new BorderLayout());
		
		barra = new JToolBar();
		
		JButton volver = new JButton("Volver");
		barra.add(volver);
		
		panelSup.add(barra, BorderLayout.NORTH);
		add(panelSup);
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventRes.setVisible( false );
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setSize(700,700);
				vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vp.setVisible(true);
				dispose();
				
			}
		});
		
	}

	public static void main(String args[]) {
		ventRes.setTitle("repuestos");
		ventRes.setSize(700, 700);
		ventRes.setLocation(550, 300);
		ventRes.setVisible(true);
		ventRes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventRes.setResizable(false);
	}
}
