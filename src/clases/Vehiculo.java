package clases;

public class Vehiculo {
	private TipoVehiculo tipo;
	private String modelo;
	private MarcaVehiculo marca;
	private int id;
	private float precio;
	
	public Vehiculo(TipoVehiculo tipo, MarcaVehiculo marca, String modelo,int id, float precio) {
		this.tipo = tipo;
		this.modelo = modelo;
		this.marca = marca;
		this.id = id;
		this.precio = precio;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
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
}
