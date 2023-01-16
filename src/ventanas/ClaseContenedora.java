package ventanas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.MarcaVehiculo;
import clases.TipoRepuesto;
import clases.TipoVehiculo;
import clases.Usuario;

public class ClaseContenedora {
	private static Logger logger = Logger.getLogger("ClaseContenedora");
	
	
	///////////////////////////////////////////////////
	//////////// Inicializa una bbdd  ///////////
	///////////////////////////////////////////////////
	public boolean init(String nombredb) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
		    Class.forName("org.sqlite.JDBC");
		    conn = DriverManager.getConnection("jdbc:sqlite:" + nombredb );
			logger.log( Level.INFO, "Conectada base de datos " + nombredb );
			stmt = conn.createStatement();
			stmt.setQueryTimeout( 10 );
			stmt.executeUpdate("create table if not exists usuario (nombre string, contrasena string, admin integer, dinero integer)");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			logger.log( Level.SEVERE, "Error en conexión de base de datos " + nombredb, e );
			return false;
		}
	}
	

	///////////////////////////////////////////////////
	//////////// SACAR USUARIOS DE LA BBDD  ///////////
	///////////////////////////////////////////////////
	public ArrayList<Usuario> sacarUsuarios(String nombredb){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
			ArrayList<Usuario> dev = new ArrayList<>();
			String sql = "SELECT * FROM usuario";
			logger.log(Level.INFO, "Statement: " + sql);
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while( rs.next() ) { 
				String nombre = rs.getString("nombre");
				String contrasena = rs.getString("contrasena");
				int admin = rs.getInt("admin");
				int dinero = rs.getInt("dinero");
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
	public void guardarDBUsuario(String nombredb, String nombre, String contrasena, int admin, int dinero){
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
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
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
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
	/////////// FUNCION PARA METER UN VEHICULO EN LA BASE DE DATOS //////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void guardarDBVehiculo(String nombredb, int id, TipoVehiculo tipo, String modelo, MarcaVehiculo marca, int precio){
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("INSERT INTO vehiculos VALUES ( %d, '%s', '%s', '%s', %d)", id, tipo, modelo, marca, precio);
			logger.log(Level.INFO, "Statement: " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM vehiculos");
			stmt2.close();
			rs.close();
			conn.close(); 
			} catch (SQLException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
			}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// FUNCION PARA METER UN REPUESTO EN LA BASE DE DATOS //////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void guardarDBRepuesto(String nombredb, int id, TipoRepuesto tipo, int compra, int venta){
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("INSERT INTO repuestos VALUES ( %d, '%s', %d, %d)", id, tipo, compra, venta);
			logger.log(Level.INFO, "Statement: " + sql);
			stmt.executeUpdate(sql);
			stmt.close();
			Statement stmt2 = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM repuestos");
			stmt2.close();
			rs.close();
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
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
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
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	/////// FUNCION PARA CAMBIAR LA CANTIDAD DE DINERO DEL USUARIO SELECCIONADO EN LA BD ///////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public void cambiarDineroBD(String nombredb,String nombre, int newDinero){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
			String sql = String.format("UPDATE usuario SET dinero = '"+newDinero+"' where nombre = '"+ nombre+"';");
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
	///////////////////////////// FUNCION PARA BUSCAR UN USUARIO POR SU NOMBRE //////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public Usuario buscarUsuarioPorNombre(String nombredb, String nombre) {
		String sql = "select * from usuario where nombre = '" + nombre + "'";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/"+nombredb);
			Statement stmt = conn.createStatement();
			logger.log(Level.INFO, "Lanzada consulta a base de datos: " + sql);
			ResultSet rs = stmt.executeQuery( sql );
			if (rs.next()) {
				Usuario usuario = new Usuario(
					rs.getString("nombre"), rs.getString("contrasena"), rs.getInt("admin"), rs.getInt("dinero") );
				rs.close();
				return usuario;
			} else {
				rs.close();
				return null;
			}
		} catch (SQLException e) {
			logger.log( Level.SEVERE, "Error en búsqueda de base de datos: " + sql, e );
			return null;
		}
	}
}

