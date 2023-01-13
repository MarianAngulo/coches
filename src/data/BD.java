package data;

import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.Level;

public class BD {
		private static Connection conn;
		public static int id=0;
		private static Logger logger = Logger.getLogger("BD");
	
	public static boolean conexionBd( String nomBD, boolean reinicio ) {
		try {
			logger.log( Level.INFO, "Carga de la libreria org.sqlite.JDBC" );
			Class.forName("org.sqlite.JDBC");  
			logger.log( Level.INFO, "Conexion con la base de datos " + nomBD );
			conn = DriverManager.getConnection("jdbc:sqlite:" + nomBD );
			if (reinicio) {
				Statement statement = conn.createStatement();
				String sentencia = "DROP TABLE IF EXISTS ";
				
			}
			return true;
		} catch(Exception e) {
			logger.log( Level.SEVERE, "Excepcion:", e );
			return false;
		}
	}
	
	
		public static void cierreBD() {
			try {
				logger.log(Level.INFO, "Cierre de conexion BaseDeDatos");
				conn.close();
			}catch(SQLException e){
				logger.log(Level.SEVERE, "Excepcion:", e);	
			}
		}
}
		
		