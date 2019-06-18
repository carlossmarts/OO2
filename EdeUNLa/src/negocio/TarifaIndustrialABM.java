package negocio;

import java.util.List;
import dao.TarifaIndustrialDao;
import datos.TarifaIndustrial;
import datos.Tension;

public class TarifaIndustrialABM {

	private static TarifaIndustrialABM instancia = null;

	public static TarifaIndustrialABM getInstance() {
		if (instancia == null) {
			instancia = new TarifaIndustrialABM();
		}
		return instancia;
	}

	// Traer por clacve primaria

	public TarifaIndustrial traerTarifaIndustrial(int idTarifaIndustrial) throws Exception {
		TarifaIndustrial c = TarifaIndustrialDao.getInstance().traerTarifaIndustrial(idTarifaIndustrial);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe TarifaIndustrial con el id indicado");
		}
		return c;
	}

	//TRAER POR CODIGO
	public TarifaIndustrial traerTarifaIndustrial (String codigo) throws Exception{
		TarifaIndustrial t = TarifaIndustrialDao.getInstance().traerTarifaIndustrial(codigo);
		if(t==null){
			throw new Exception("Error en la capa de negocio, no existe TarifaIndustrial con el código indicado");
		}
		return t;
	}
	
	public int agregar(String codigo, int limiteConsumo, boolean consumoMayor, String tension, double cargoFijo,
			double cargoVariablePico, double cargoVariableValle, double cargoVariableResto) throws Exception {
		TarifaIndustrial t = TarifaIndustrialDao.getInstance().traerTarifaIndustrial(codigo);
		if(t != null){
			throw new Exception ("Error en la capa de negocio, ya existe TarifaIndustrial con el codigo indicado");
		}
		TarifaIndustrial c = new TarifaIndustrial(codigo, limiteConsumo, consumoMayor, tension, cargoFijo, cargoVariablePico, cargoVariableValle, cargoVariableResto);
		return TarifaIndustrialDao.getInstance().agregar(c); // devuelve id agregado
	}

	public void modificarTarifaIndustrial(TarifaIndustrial c) throws Exception {
		// implementar excepción
		TarifaIndustrialDao.getInstance().actualizar(c);
	}

	public void eliminar(int pk) throws Exception {
		TarifaIndustrial c = traerTarifaIndustrial(pk);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe TarifaIndustrial con el id indicado");
		}
		TarifaIndustrialDao.getInstance().eliminar(c);
	}

	public List<TarifaIndustrial> traerTarifaIndustrial() {
		return TarifaIndustrialDao.getInstance().traerTarifaIndustrial();
	}
	
	public TarifaIndustrial traer(int consumo, String tension) {
		TarifaIndustrial retorno = null;
		for (TarifaIndustrial t : traerTarifaIndustrial()) {
			if (t.getTension().equals(tension) && t.getLimiteConsumo() > consumo  && !(t.isConsumoMayor())) {
				retorno = t;
			}
			if (t.getTension().equals(tension) && t.getLimiteConsumo() <= consumo  && t.isConsumoMayor()) {
				retorno = t;
			}
		}
		return retorno;
	}
}
