package datos;

import java.time.LocalDate;
import java.util.Set;

import funciones.Funciones;
import negocio.ClienteABM;


public class Factura {

	private int idFactura;
	private int nroMedidor;
	private String direccion;
	private LocalDate fecha;
	private double totalPagar;
	private String observaciones;
	private int idCliente;
	private Set <ItemFactura> lstItem;
	

	public Factura() {}

	public Factura(int nroMedidor, String direccion, LocalDate fecha, double totalPagar,
			String observaciones, int idCliente) {
		super();
		this.nroMedidor = nroMedidor;
		this.direccion = direccion;
		this.fecha = fecha;
		this.totalPagar = totalPagar;
		this.observaciones = observaciones;
		this.idCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}


	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public int getNroMedidor() {
		return nroMedidor;
	}


	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotalPagar() {
		return totalPagar;
	}


	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Set<ItemFactura> getLstItem() {
		return lstItem;
	}


	public void setLstItem(Set<ItemFactura> lstItem) {
		this.lstItem = lstItem;
	}


	@Override
	public String toString() {
		String retorno = "Factura: " + idFactura;
		retorno += "\n numero de medidor: " + nroMedidor;
		retorno += "\n fecha: " + Funciones.traerFechaCorta(fecha);
		
		try{
			retorno += ClienteABM.getInstance().traerCliente(idCliente).toString();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		retorno += "\nMedidor:\nDireccion: " + direccion;
		for (ItemFactura item : lstItem){
			retorno += "\n" + item.toString();
		}
		retorno += "\n total a pagar : " + totalPagar;
		retorno += "\n observaciones" + observaciones;
		
		return retorno;
	}

	
	
}
