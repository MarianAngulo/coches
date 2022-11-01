package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Usuario;

public class ClaseContenedora {
	private static Logger logger = Logger.getLogger("ClaseContenedora");
	
	///////////////////////////////////////////////////
	//////////// SACAR USUARIOS DE LA BBDD  ///////////
	///////////////////////////////////////////////////
	public ArrayList<Usuario> sacarUsuarios(String nombredb){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/"+nombredb);
			Statement stmt = conn.createStatement();
			ArrayList<Usuario> dev = new ArrayList<>();
			String sql = "SELECT * FROM usuario";
			logger.log(Level.INFO, "Statement: " + sql);
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while( rs.next() ) { 
				String nombre = rs.getString("nombre");
				String contrasena = rs.getString("contrasena");
				int admin = rs.getInt("admin");
				float dinero = rs.getInt("dinero");
				dev.add( new Usuario( nombre, contrasena, admin, dinero) );
			}
			rs.close();
			stmt.close();
			conn.close(); 
			return dev;
			} catch (SQLException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			e.printStackTrace();
			}
			return null;
		
	}
	

	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA METER UN USUARIO EN LA BASE DE DATOS //////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void guardarDBUsuario(String nombredb, String nombre, String contrasena, int admin, float dinero){
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("INSERT INTO usuario VALUES ('%s', '%s', %d, %d)", nombre, contrasena, admin, dinero);
			logger.log(Level.INFO, "Statement: " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			stmt2.close();
			rs.close();
			conn.close(); 
			} catch (SQLException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA BORRAR UN USUARIO DE LA BASE DE DATOS /////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void borrarDBUsuario(String nombredb,String nombre){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("DELETE FROM usuario where nombre = '"+ nombre+"';");
			logger.log(Level.INFO, "Statement: " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close(); 
			} catch (SQLException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA CAMBIAR LA CONTRASEÑA DEL USUARIO SELECCIONADO EN LA BD ///////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void cambiarContrasenaBD(String nombredb,String nombre, String contrasena, String nuevaContra){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("UPDATE usuario SET contrasena = '"+nuevaContra+"' where nombre = '"+ nombre+"' AND contrasena= '"+contrasena+"';");
			logger.log(Level.INFO, "Statement: " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			stmt2.close();
			rs.close();
			conn.close(); 
			} catch (SQLException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		
	}
}

