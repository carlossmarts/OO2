package datos;

import java.time.LocalDate;
import java.time.LocalTime;

import funciones.Funciones;

public class Lectura {

	private long idLectura;
	private Medidor medidor;
	private LocalDate fecha;
	private LocalTime hora;
	private Inspector inspector; 
	
	public Lectura() {
		super();
	}

	public Lectura(Medidor medidor, LocalDate fecha, LocalTime hora, Inspector inspector) {
		super();
		this.medidor = medidor;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
	}
	
	public String toString(){
		return "Lectura " + idLectura + ", medidor nro: " + medidor.getNroSerie() + ", fecha: " + Funciones.traerFechaCorta(fecha);
	}

	public long getIdLectura() {
		return idLectura;
	}

	protected void setIdLectura(long idLectura) {
		this.idLectura = idLectura;
	}

	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	
}
