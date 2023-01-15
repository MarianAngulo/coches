package bd;

import java.sql.Connection;
import java.util.logging.Logger;

import ventanas.ClaseContenedora;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;

public class BD {
	private static Connection conn;
	public static int id = 0;
	private static Logger logger = Logger.getLogger("BD");
	

	public static boolean conexionBd(String nomBD, boolean reinicio) {
		try {
			logger.log(Level.INFO, "Carga de la libreria org.sqlite.JDBC");
			Class.forName("org.sqlite.JDBC");
			logger.log(Level.INFO, "Conexion con la base de datos " + nomBD);
			conn = DriverManager.getConnection("jdbc:sqlite:" + nomBD);
			if (reinicio) {
				Statement statement = conn.createStatement();
				String sentencia = "DROP TABLE IF EXISTS ";

			}
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Excepcion:", e);
			return false;
		}
	}

	public static void cierreBD() {
		try {
			logger.log(Level.INFO, "Cierre de conexion BaseDeDatos");
			conn.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Excepcion:", e);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA LEER UN CSV ///////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void leerCSV(String archivo) { 
		String path = "data/"+archivo+".csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null) {
				
				String[] values = line.split(",");
				String bd = "Usuario";
				String nombre = values[0];
				String contrasena = values[1];
				int admin = Integer. parseInt(values[2]);
				float dinero = Float. parseFloat(values[3]);
				ClaseContenedora claseContenedora = new ClaseContenedora();
				claseContenedora.guardarDBUsuario(bd, nombre, contrasena, admin, dinero);
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
