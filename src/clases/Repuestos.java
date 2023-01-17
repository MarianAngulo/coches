package clases;



public class Repuestos {
	private TipoRepuesto tipo;
	private int Id;
	private int compra;
	private int venta;
	private String url;
	
	
	public Repuestos(int Id, TipoRepuesto tipo,  int compra, int venta, String url) {
		this.Id = Id;
		this.tipo = tipo;
		this.compra = compra;
		this.venta = venta;
		this.url = url;
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
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

}

