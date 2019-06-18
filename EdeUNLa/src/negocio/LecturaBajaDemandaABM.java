package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.List;

import dao.LecturaAltaDemandaDao;
import dao.LecturaBajaDemandaDao;
import datos.Inspector;
import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.TarifaIndustrial;
import datos.TarifaResidencial;

public class LecturaBajaDemandaABM {
	private static LecturaBajaDemandaABM instancia = null;

	public static LecturaBajaDemandaABM getInstance (){
		if(instancia == null){
			instancia = new LecturaBajaDemandaABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public LecturaBajaDemanda traerLecturaBajaDemanda(long idLecturaBajaDemanda) throws Exception{
		LecturaBajaDemanda c= LecturaBajaDemandaDao.getInstance().traerLecturaBajaDemanda(idLecturaBajaDemanda);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe LecturaBajaDemanda con el id indicado");
		}
		return c;
	}
	
	public int agregar(Medidor medidor, LocalDate fecha, LocalTime hora, Inspector inspector, int consumo) throws Exception{
		LecturaBajaDemanda l = traer(medidor.getNroSerie(), fecha.getYear(), fecha.getMonthValue());
		if (l!=null){
			throw new Exception("Error en la capa de negocio, ya existe una lectura baja demanda para ese medidor, mes y año");
		}
		LecturaBajaDemanda c = new LecturaBajaDemanda(medidor,fecha,hora,inspector,consumo);
		return LecturaBajaDemandaDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarLecturaBajaDemanda (LecturaBajaDemanda c) throws Exception{
		LecturaBajaDemanda l = traer(c.getMedidor().getNroSerie(), c.getFecha().getYear(), c.getFecha().getMonthValue());
		if (l!=null){
			throw new Exception("Error en la capa de negocio, ya existe una lectura baja demanda para ese medidor, mes y año");
		}
		LecturaBajaDemandaDao.getInstance().actualizar(c);
	}
	
	public void eliminar(long pk) throws Exception {
		LecturaBajaDemanda c = traerLecturaBajaDemanda(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe LecturaBajaDemanda con el id indicado");
		}
		LecturaBajaDemandaDao.getInstance().eliminar(c);
	}
	
	public List<LecturaBajaDemanda>traerLecturaBajaDemanda(int nroSerie){
		return LecturaBajaDemandaDao.getInstance().traerLecturaBajaDemanda(nroSerie);
	}
	
	public LecturaBajaDemanda traer(int nroSerie, int anio, int mes){
		LecturaBajaDemanda retorno = null;
		for(LecturaBajaDemanda l : LecturaBajaDemandaDao.getInstance().traerLecturaBajaDemanda(nroSerie)){
			LocalDate fecha = l.getFecha();
			if (fecha.getMonthValue()==mes && fecha.getYear()==anio){
				retorno = l;
			}
		}
		return retorno;
	}
	
	public int calcularConsumo(LecturaBajaDemanda actual) {
		int consumo = actual.getConsumo();
		LecturaBajaDemanda anterior = (LecturaBajaDemanda) LecturaABM.getInstance().traerLecturaAnterior(actual);
		if (anterior != null) {
			consumo -= anterior.getConsumo();
		}
		return consumo;
	}
}
	 