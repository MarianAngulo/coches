package ventanas;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

		private static final Logger logger = Logger.getLogger("Main");


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaRegistro frame = new VentanaRegistro();
						frame.setVisible(true);
						frame.setLocation(350,150);
					} catch (Exception e) {
						logger.log(Level.SEVERE, "Error", e);
					}
				}
			});
		}

	}
