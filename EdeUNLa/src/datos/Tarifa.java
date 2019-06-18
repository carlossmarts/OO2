package datos;

public abstract class Tarifa {

	private int idTarifa;
	private String codigo;
	
	public Tarifa() {
		super();
	}

	public Tarifa(String codigo) {
		super();
		this.codigo = codigo;
	}

	public int getIdTarifa() {
		return idTarifa;
	}

	protected void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "tarifa n° " + idTarifa + " - codigo: " + codigo;
	}
	
	
}
