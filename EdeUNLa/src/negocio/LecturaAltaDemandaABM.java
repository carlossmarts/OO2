package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.List;
import dao.LecturaAltaDemandaDao;
import datos.Inspector;
import datos.Lectura;
import datos.LecturaAltaDemanda;
import datos.Medidor;
import datos.TarifaIndustrial;

public class LecturaAltaDemandaABM {
	private static LecturaAltaDemandaABM instancia = null;

	public static LecturaAltaDemandaABM getInstance (){
		if(instancia == null){
			instancia = new LecturaAltaDemandaABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public LecturaAltaDemanda traerLecturaAltaDemanda(int idLecturaAltaDemanda) throws Exception{
		LecturaAltaDemanda c= LecturaAltaDemandaDao.getInstance().traerLecturaAltaDemanda(idLecturaAltaDemanda);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe LecturaAltaDemanda con el id indicado");
		}
		return c;
	}

	
	//traer por clave candidata. Requiere un metodo implementado en el DAO
/*
	public LecturaAltaDemanda traerLecturaAltaDemanda(TarifaIndustrial tarifa){
		LecturaAltaDemanda c=LecturaAltaDemandaDao.getInstance().traerLecturaAltaDemanda(tarifa);
		return c;
	}
*/	
	public int agregar(Medidor medidor, LocalDate fecha, LocalTime hora, Inspector inspector, int consumoPico, int consumoValle, int consumoResto) throws Exception{
		Lectura l = traer(medidor.getNroSerie(), fecha.getYear(), fecha.getMonthValue());
		if (l != null){
			throw new Exception("Error en la capa de negocio, ya existe una lecturaAltaDemanda para ese medidor, mes y año");
		}
		LecturaAltaDemanda c = new LecturaAltaDemanda(medidor,fecha,hora,inspector,consumoPico,consumoValle,consumoResto);
		return LecturaAltaDemandaDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarLecturaAltaDemanda (LecturaAltaDemanda c) throws Exception{
		LecturaAltaDemandaDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		LecturaAltaDemanda c = traerLecturaAltaDemanda(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe LecturaAltaDemanda con el id indicado");
		}
		LecturaAltaDemandaDao.getInstance().eliminar(c);
	}
	
	public List<LecturaAltaDemanda> traerLecturasAltaDemanda(int nroSerie){
		return LecturaAltaDemandaDao.getInstance().traerLecturasAltaDemanda(nroSerie);
	}
	
	public LecturaAltaDemanda traer(int nroSerie, int anio, int mes){
		LecturaAltaDemanda retorno = null;
		for(LecturaAltaDemanda l : LecturaAltaDemandaDao.getInstance().traerLecturasAltaDemanda(nroSerie)){
			LocalDate fecha = l.getFecha();
			if (fecha.getMonthValue()==mes && fecha.getYear()==anio){
				retorno = l;
			}
		}
		return retorno;
	}
	
	public int calcularConsumoPico (LecturaAltaDemanda actual) {
		int consumo = actual.getConsumoPico();
		LecturaAltaDemanda anterior = (LecturaAltaDemanda) LecturaABM.getInstance().traerLecturaAnterior(actual);
		if(anterior != null) {
			consumo -= anterior.getConsumoPico();
		}
		return consumo;
	}
	
	public int calcularConsumoValle (LecturaAltaDemanda actual) {
		int consumo = actual.getConsumoValle();
		LecturaAltaDemanda anterior = (LecturaAltaDemanda) LecturaABM.getInstance().traerLecturaAnterior(actual);
		if(anterior != null) {
			consumo -= anterior.getConsumoValle();
		}
		return consumo;
	}
	
	public int calcularConsumoResto (LecturaAltaDemanda actual) {
		int consumo = actual.getConsumoResto();
		LecturaAltaDemanda anterior = (LecturaAltaDemanda) LecturaABM.getInstance().traerLecturaAnterior(actual);
		if(anterior != null) {
			consumo -= anterior.getConsumoResto();
		}
		return consumo;
	}
	
	
}
	 