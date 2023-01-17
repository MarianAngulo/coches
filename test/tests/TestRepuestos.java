package tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Repuestos;
import clases.TipoRepuesto;

public class TestRepuestos {
	
	private Repuestos repuestos;
	private int id = 12;
	private TipoRepuesto tipo = TipoRepuesto.MOTOR;
	private int compra = 24;
	private int venta = 15;
	private String url = "";

	@Before
	public void setUp() throws Exception {
		repuestos = new Repuestos(id, tipo, compra, venta, url);
	}

	@After
	public void tearDown() throws Exception {
		repuestos = null;
	}
	

	@Test
	public void testRepuestos() {
		assertNotNull(repuestos);
		assertEquals(id, repuestos.getId());
		assertEquals(tipo, TipoRepuesto.valueOf("MOTOR"));
		assertEquals(compra, repuestos.getCompra(), 0);
		assertEquals(venta, repuestos.getVenta(), 0);
	}

	@Test
	public void testGetTipo() {
		assertEquals(tipo, TipoRepuesto.valueOf("MOTOR"));
	}

	@Test
	public void testSetTipo() {
		TipoRepuesto tip = TipoRepuesto.NEUMATICO;
		repuestos.setTipo(tip);
		assertEquals(tip, TipoRepuesto.valueOf("NEUMATICO"));
	}

	@Test
	public void testGetId() {
		assertEquals(id, repuestos.getId());
	}

	@Test
	public void testSetId() {
		int ide = 23;
		repuestos.setId(ide);
		assertEquals(ide, repuestos.getId());
	}

	@Test
	public void testGetUrl() {
		assertEquals(url, repuestos.getUrl());
	}

	@Test
	public void testSetUrl() {
		String url2 = "img/repuestos/motor1.jpg";
		repuestos.setUrl(url2);
		assertEquals(url2, repuestos.getUrl());
	}
	
	@Test
	public void testGetCompra() {
		assertEquals(compra, repuestos.getCompra(),0);
		
	}

	@Test
	public void testSetCompra() {
		int comp = 2;
		repuestos.setCompra(comp);
		assertEquals(comp, repuestos.getCompra(),0);
	}

	@Test
	public void testGetVenta() {
		assertEquals(venta, repuestos.getVenta(),0);
	}

	@Test
	public void testSetVenta() {
		int vent = 22;
		repuestos.setVenta(vent);
		assertEquals(vent, repuestos.getVenta(),0);
	}

}
