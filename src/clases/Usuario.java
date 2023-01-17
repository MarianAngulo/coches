package clases;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String contrasena;
	private int admin;
	private int dinero;
	private ArrayList<Vehiculo> listaVehiculos;
	private ArrayList<Repuestos> listaRepuestos;

	public Usuario(String nombre, String contrasena, int admin, int dinero, ArrayList<Vehiculo> listaVehiculos,
			ArrayList<Repuestos> listaRepuestos) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.admin = admin;
		this.dinero = dinero;
		this.listaVehiculos = listaVehiculos;
		this.listaRepuestos = listaRepuestos;
	}

	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public ArrayList<Repuestos> getListaRepuestos() {
		return listaRepuestos;
	}

	public void setListaRepuestos(ArrayList<Repuestos> listaRepuestos) {
		this.listaRepuestos = listaRepuestos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public int getAdmin() {
		return admin;
	}
	
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public int getDinero() {
		return dinero;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", admin=" + admin + ", dinero=" + dinero + "]";
	}
	
	
}
