package clases;



public class Repuestos {
	private TipoRepuesto tipo;
	private int Id;
	private float compra;
	private float venta;
	
	
	public Repuestos(int Id, TipoRepuesto tipo,  float compra, float venta) {
		this.Id = Id;
		this.tipo = tipo;
		this.compra = compra;
		this.venta = venta;
	}

	public TipoRepuesto getTipo() {
		return tipo;
	}

	public void setTipo(TipoRepuesto tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public float getCompra() {
		return compra;
	}


	public void setCompra(float compra) {
		this.compra = compra;
	}


	public float getVenta() {
		return venta;
	}


	public void setVenta(float venta) {
		this.venta = venta;
	}

}

