package datos;

import java.util.Set;

public class Inspector {

	private int idInspector;
	private String cuil;
	private Set<Zona> zonas;

	public Inspector() {
		super();
	}

	public Inspector(String cuil) {
		super();
		this.cuil=cuil;
	}

	public int getIdInspector() {
		return idInspector;
	}

	protected void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}

	public Set<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(Set<Zona> zonas) {
		this.zonas = zonas;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	@Override
	public String toString() {
		return "Inspector " + idInspector + "\n cuil:" + cuil ;
	}

}
