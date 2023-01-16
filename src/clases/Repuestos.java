package clases;



public class Repuestos {
	private TipoRepuesto tipo;
	private int Id;
	private int compra;
	private int venta;
	
	
	public Repuestos(int Id, TipoRepuesto tipo,  int compra, int venta) {
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


	public int getCompra() {
		return compra;
	}


	public void setCompra(int compra) {
		this.compra = compra;
	}


	public int getVenta() {
		return venta;
	}


	public void setVenta(int venta) {
		this.venta = venta;
	}

}

