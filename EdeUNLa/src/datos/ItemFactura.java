package datos;

public class ItemFactura {
	private int idItemFactura;
	private String detalle;
	private double precioUnitario;
	private int cantidad;
	private String unidad;
	private Factura factura;
	
	public ItemFactura() {
		super();
	}
	

	public ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura f) {
		super();
		this.detalle = detalle;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.setFactura(f);
	}



	public int getIdItemFactura() {
		return idItemFactura;
	}

	protected void setIdItemFactura(int idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	@Override
	public String toString() {
		return detalle + ": " + cantidad + " " + unidad + " - precio unitario: " + precioUnitario + " - Subtotal: " + calcularSubtotal();
	}
	
	public double calcularSubtotal(){
		return precioUnitario*cantidad;
	}
	

}
