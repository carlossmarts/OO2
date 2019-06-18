package datos;

public class Medidor {

	private int idMedidor;
	private int nroSerie;
	private Cliente cliente;
	private String direccion;
	private Zona zona;
	private boolean esBaja; //indica si el medidor es residencial o industrial
	private String tension;	//para medidores de alta demanda
	

	public Medidor() {
		super();
	}
	
	public Medidor(int nroSerie, Cliente cliente, String direccion, Zona zona, boolean esBaja, String tension) {
		super();
		this.nroSerie = nroSerie;
		this.cliente = cliente;
		this.direccion = direccion;
		this.zona = zona;
		this.esBaja = esBaja;
		this.tension = tension;
	}

	
	public String getTension() {
		return tension;
	}

	public void setTension(String tension) {
		this.tension = tension;
	}

	public int getIdMedidor() {
		return idMedidor;
	}

	public void setIdMedidor(int idMedidor) {
		this.idMedidor = idMedidor;
	}

	public boolean isEsBaja() {
		return esBaja;
	}

	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	

	@Override
	public String toString() {
		String retorno = "Medidor " + nroSerie;
		retorno += "\nDireccion: " + direccion;
		retorno += ", Zona " + zona.getNombre();
		retorno += "\ncliente cuil/cuit: " + cliente.getCuil_cuit();
		return retorno;
	}
	
	
}
