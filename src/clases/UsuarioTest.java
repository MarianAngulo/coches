package clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuario;
	private String nombre="nombre";
	private String contrasena="contraseña";
	private boolean admin=false;
	private float dinero=0.0f;
	
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
		assertEquals(dinero, usuario.getDinero(), 0.0f);
		
		
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
		boolean adm = false;
		usuario.setAdmin(adm);
		
		assertEquals(admin, usuario.getAdmin());
	}
	@Test
	public void testGetDinero() {
		assertEquals(dinero, usuario.getDinero(), 0.0f);
	}
	
	@Test
	public void testSetPrecioHora() {
		float din = 0.0f;
		
		assertEquals(dinero, usuario.getDinero(), 0.0f);
		usuario.setDinero(din);
		assertEquals(din, usuario.getDinero(), 0.0f);
	}
	
}
