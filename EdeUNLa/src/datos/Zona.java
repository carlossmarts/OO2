package datos;

import java.util.HashSet;
import java.util.Set;

public class Zona {

	private int idZona;
	private String nombre;
	private Set<Inspector> inspectores;
	private Set<Medidor> medidores;

	public Zona() {
		super();
	}

	public Zona(String nombre) {
		super();
		this.nombre = nombre;
		this.inspectores = new HashSet<>();
		this.medidores = new HashSet<>();
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public Set<Inspector> getInspectores() {
		return inspectores;
	}

	public void setInspectores(Set<Inspector> inspectores) {
		this.inspectores = inspectores;
	}

	public Set<Medidor> getMedidores() {
		return medidores;
	}

	public void setMedidores(Set<Medidor> medidores) {
		this.medidores = medidores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Zona: " + idZona + "\n nombre: " + nombre;
	}

}
