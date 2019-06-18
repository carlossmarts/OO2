	 
package negocio;

import  java.util.List;
import java.util.Set;

import dao.InspectorDao;
import datos.Inspector;
import datos.Zona;

public class InspectorABM {
	private static InspectorABM instancia = null;

	public static InspectorABM getInstance (){
		if(instancia == null){
			instancia = new InspectorABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Inspector traerInspector(int idInspector) throws Exception{
		Inspector c= InspectorDao.getInstance().traerInspector(idInspector);
		if (c == null){
			throw new Exception ("Error en la capa de negocio, no existe Inspector con el id indicado");
		}
		return c;
	}
	
	//traer por cuil
	public Inspector traerInspector(String cuil) throws Exception{
		Inspector i = InspectorDao.getInstance().traerInspector(cuil);
		if(i == null ){
			throw new Exception ("Error en la capa de negocio, no existe Inspector con el cuil indicado");
		}
		return i;
	}

	public int agregar(String cuil) throws Exception{
		if (InspectorDao.getInstance().traerInspector(cuil) != null){
			throw new Exception ("Error en la capa de negocio, ya existe Inspector con el cuil indicado");
		}
		Inspector c = new Inspector(cuil);
		return InspectorDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	
	
	public void modificarInspector (Inspector c) throws Exception{
		//implementar excepción
		InspectorDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		Inspector c = traerInspector(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Inspector con el id indicado");
		}
		InspectorDao.getInstance().eliminar(c);
	}
	
	public List<Inspector>traerInspectoryZonas(int idInspector){
		return InspectorDao.getInstance().traerInspectorYZonas(idInspector);
	}
}
	 