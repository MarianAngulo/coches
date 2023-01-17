package clases;

public class Vehiculo {
	private TipoVehiculo tipo;
	private String modelo;
	private MarcaVehiculo marca;
	private int id;
	private int precio;
	private String url;
	
	public Vehiculo(TipoVehiculo tipo, MarcaVehiculo marca, String modelo,int id, int precio, String url) {
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.id = id;
		this.precio = precio;
		this.url = url;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", id=" + id + ", precio=" + precio + "]";
	}

	public MarcaVehiculo getMarca() {
		return marca;
	}

	public void setMarca(MarcaVehiculo marca) {
		this.marca = marca;
	}
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
}
