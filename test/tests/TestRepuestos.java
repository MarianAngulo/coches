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
	private float compra = 24.8f;
	private float venta = 15.4f;

	@Before
	public void setUp() throws Exception {
		repuestos = new Repuestos(id, tipo, compra, venta);
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
		assertEquals(compra, repuestos.getCompra(), 0.0f);
		assertEquals(venta, repuestos.getVenta(),0.0f);
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
	public void testGetCompra() {
		assertEquals(compra, repuestos.getCompra(),0.0f);
		
	}

	@Test
	public void testSetCompra() {
		float comp = 2.4f;
		repuestos.setCompra(comp);
		assertEquals(comp, repuestos.getCompra(),0.0f);
	}

	@Test
	public void testGetVenta() {
		assertEquals(venta, repuestos.getVenta(),0.0f);
	}

	@Test
	public void testSetVenta() {
		float vent = 22.5f;
		repuestos.setVenta(vent);
		assertEquals(vent, repuestos.getVenta(),0.0f);
	}

}
