package tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.MarcaVehiculo;
import clases.TipoVehiculo;
import clases.Vehiculo;

public class TestVehiculo {
	
	private Vehiculo vehiculo;
	private TipoVehiculo tipo = TipoVehiculo.CICLOMOTOR;
	private MarcaVehiculo marca = MarcaVehiculo.BMW;
	private String modelo = "M2";
	private int id = 23;
	private int precio = 2000;
	private String url = "";
	
	@Before
	public void setUp() throws Exception {
		vehiculo = new Vehiculo(tipo, marca, modelo, id, precio, url);
	}

	@After
	public void tearDown() throws Exception {
		vehiculo = null;
	}

	@Test
	public void testVehiculo() {
		assertNotNull(vehiculo);
		assertEquals(id, vehiculo.getId());
		assertEquals(tipo, TipoVehiculo.valueOf("CICLOMOTOR"));
		assertEquals(marca, MarcaVehiculo.valueOf("BMW"));
		assertEquals(modelo, vehiculo.getModelo());
		assertEquals(precio, vehiculo.getPrecio(),0.0f);
	}

	@Test
	public void testGetTipo() {
		assertEquals(tipo, TipoVehiculo.valueOf("CICLOMOTOR"));
	}

	@Test
	public void testSetTipo() {
		TipoVehiculo tip = TipoVehiculo.MOTOCICLETA;
		vehiculo.setTipo(tip);
		assertEquals(tip, TipoVehiculo.valueOf("MOTOCICLETA"));
	}
	
	@Test
	public void testGetMarca() {
		assertEquals(tipo, MarcaVehiculo.valueOf("BMW"));
	}

	@Test
	public void testSetMarca() {
		MarcaVehiculo mar = MarcaVehiculo.MERCEDES;
		vehiculo.setMarca(mar);
		assertEquals(mar, MarcaVehiculo.valueOf("MERCEDES"));
	}

	@Test
	public void testGetModelo() {
		assertEquals(modelo, vehiculo.getModelo());
	}

	@Test
	public void testSetModelo() {
		String mod = "Ferrari";
		vehiculo.setModelo(mod);
		assertEquals(mod, vehiculo.getModelo());
	}

	@Test
	public void testGetId() {
		assertEquals(id, vehiculo.getId());
	}

	@Test
	public void testSetId() {
		int ide = 65;
		vehiculo.setId(ide);
		assertEquals(ide, vehiculo.getId());
	}

	@Test
	public void testGetPrecio() {
		assertEquals(precio, vehiculo.getPrecio(),0.0f);

	}

	@Test
	public void testSetPrecio() {
		int prec = 12000;
		vehiculo.setPrecio(prec);
		assertEquals(prec, vehiculo.getPrecio(),0);

	}

	@Test
	public void testToString() {
		String esperado = "Vehiculo [tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", id=" + id + ", precio=" + precio + "]";
		assertEquals(esperado,vehiculo.toString());
	}

}
