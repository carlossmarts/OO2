package datos;

import java.util.Set;

public class Cliente {

	private int idCliente;
	private String cuil_cuit;
	private Contacto contacto;
	private Set<Medidor> medidores; 
	
	
	public Cliente() {
		super();
	}

	public Cliente(String cuil_cuit) {
		super();
		this.cuil_cuit=cuil_cuit;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCuil_cuit() {
		return cuil_cuit;
	}

	public void setCuil_cuit(String cuil_cuit) {
		this.cuil_cuit = cuil_cuit;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Set<Medidor> getMedidores() {
		return medidores;
	}

	public void setMedidores(Set<Medidor> medidores) {
		this.medidores = medidores;
	}

	@Override
	public String toString() {
		String retorno = "Cliente: " + idCliente;
		retorno += "\n Cuil/Cuit: " + cuil_cuit;
		retorno += contacto.toString();
		return retorno;
	}
	

	
	
}
