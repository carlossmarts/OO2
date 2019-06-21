package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import  java.util.List;
import dao.LecturaDao;
import datos.Inspector;
import datos.Lectura;
import datos.Medidor;

public class LecturaABM {
	private static LecturaABM instancia = null;

	public static LecturaABM getInstance (){
		if(instancia == null){
			instancia = new LecturaABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Lectura traerLectura(int idLectura) throws Exception{
		Lectura c= LecturaDao.getInstance().traerLectura(idLectura);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Lectura con el id indicado");
		}
		return c;
	}

	
	
	public void modificarLectura (Lectura c) throws Exception{
		//implementar excepción
		LecturaDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		Lectura c = traerLectura(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Lectura con el id indicado");
		}
		LecturaDao.getInstance().eliminar(c);
	}
	
	public void bajaLogica (int idLectura) {
		Lectura l = LecturaDao.getInstance().traerLectura(idLectura);
		l.setInactiva(true);
		l.setFecha(null);
		l.setMedidor(null);
		LecturaDao.getInstance().actualizar(l);
	}
	
	public List<Lectura>traerLecturas(){
		return LecturaDao.getInstance().traerLecturas();
	}
	
	public Lectura traerLectura(Medidor m, int anio, int mes) throws Exception{
		Lectura retorno = null;
		List<Lectura> lecs = LecturaDao.getInstance().traerLecturas(m);
		for(Lectura l : lecs){
			LocalDate fechaLectura = l.getFecha();
			if ((fechaLectura.getMonthValue()==mes) && (fechaLectura.getYear()==anio)){
				retorno = l;
			}
		}
		if (retorno == null){
			throw new Exception ("Error en capa de negocio, no se encontro una lectura para el medidor, mes y año indicados");
		}
		return retorno;
	}
	
	public Lectura traerLecturaAnterior (Lectura l) {
		Lectura retorno = null;
		LocalDate fechaLecturaAnterior = l.getFecha().minus(2, ChronoUnit.MONTHS);
		int mesFechaAnterior = fechaLecturaAnterior.getMonthValue();
		int anioFechaAnterior = fechaLecturaAnterior.getYear();
		try {
			retorno = traerLectura(l.getMedidor(), anioFechaAnterior, mesFechaAnterior);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
}