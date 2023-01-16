package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Usuario;

public class UsuarioTest {

	private Usuario usuario;
	private String nombre="nombre";
	private String contrasena="contraseña";
	private int admin=0;
	private int dinero=0;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(nombre,contrasena,admin,dinero);
	}

	@After
	public void tearDown() throws Exception {
		usuario = null;
	}
	@Test
	public void testUsuario() {
		assertNotNull(usuario);
		assertEquals(nombre, usuario.getNombre());
		assertEquals(contrasena, usuario.getContrasena());
		assertEquals(admin, usuario.getAdmin());
		assertEquals(dinero, usuario.getDinero(), 0);
		
		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void testSetNombre() {
		String nom = "nombre";
		usuario.setNombre(nom);
		
		assertEquals(nombre, usuario.getNombre());
	}
	
	@Test
	public void testGetContrasena() {
		assertEquals(contrasena, usuario.getContrasena());
	}

	@Test
	public void testSetContrasena() {
		String con = "contraseña";
		usuario.setContrasena(con);
		
		assertEquals(contrasena, usuario.getContrasena());
	}
	
	@Test
	public void testGetAdmin() {
		assertEquals(admin, usuario.getAdmin());
	}

	@Test
	public void testSetAdmin() {
		int adm = 0;
		usuario.setAdmin(adm);
		
		assertEquals(admin, usuario.getAdmin());
	}
	@Test
	public void testGetDinero() {
		assertEquals(dinero, usuario.getDinero(), 0);
	}
	
	@Test
	public void testSetPrecioHora() {
		int din = 0;
		
		assertEquals(dinero, usuario.getDinero(), 0.0f);
		usuario.setDinero(din);
		assertEquals(din, usuario.getDinero(), 0.0f);
	}
	
}
