package clases;

public class Usuario {
	private String nombre;
	private String contrasena;
	private int admin;
	private float dinero;
	
	public Usuario(String nombre, String contrasena, int admin, float dinero) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.admin = admin;
		this.dinero = dinero;
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
	
	public float getDinero() {
		return dinero;
	}
	
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", admin=" + admin + ", dinero=" + dinero + "]";
	}
	
	
}
