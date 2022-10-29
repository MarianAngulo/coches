package clases;

import java.util.Date;

public class Venta {
	private Usuario usuario;
	private String producto;
	private float precio;
	private Date fecha;
	
	public Venta(Usuario usuario, String producto, float precio, Date fecha) {
		this.usuario = usuario;
		this.producto = producto;
		this.precio = precio;
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}

