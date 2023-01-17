package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Usuario;
import clases.Venta;

public class VentaTest {

	private Venta venta;
	private Usuario usuario;
	private int producto = 1;
	private float precio = 0.0f;
	private Date fecha = new Date();

	@Before
	public void setUp() throws Exception {
		venta = new Venta(usuario, producto, precio, fecha);
	}

	@After
	public void tearDown() throws Exception {
		venta = null;
	}

	@Test
	public void testVenta() {
		assertNotNull(venta);
		assertEquals(usuario, venta.getUsuario());
		assertEquals(producto, venta.getProducto());
		assertEquals(precio, venta.getPrecio(), 0.0f);
		assertEquals(fecha, venta.getFecha());

	}
	
	@Test
	public void testGetProducto() {
		assertEquals(producto, venta.getProducto());
	}

	@Test
	public void testSetProducto() {
		int prod = 1;
		venta.setProducto(prod);
		
		assertEquals(producto, venta.getProducto());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(precio, venta.getPrecio(), 0.0f);
	}
	
	@Test
	public void testSetPrecio() {
		float pre = 0.0f;
		
		assertEquals(precio, venta.getPrecio(), 0.0f);
		venta.setPrecio(pre);
		assertEquals(precio, venta.getPrecio(), 0.0f);
	}
	
	@Test
	public void testGetFecha() {
		assertEquals(fecha, venta.getFecha());
	}
	
	@Test
	public void testSetFecha() {
		Date current = new Date();
		
		venta.setFecha(fecha);
		assertEquals(current, venta.getFecha());
	}
	
}
