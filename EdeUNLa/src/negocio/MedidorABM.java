package negocio;

import  java.util.List;

import dao.MedidorDao;
import datos.Cliente;
import datos.Medidor;
import datos.Zona;
import datos.Tarifa;

public class MedidorABM {
	private static MedidorABM instancia = null;

	public static MedidorABM getInstance (){
		if(instancia == null){
			instancia = new MedidorABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Medidor traerMedidor(int idMedidor) throws Exception{
		Medidor c= MedidorDao.getInstance().traerMedidor(idMedidor);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Medidor con el id indicado");
		}
		return c;
	}

	
	//traer por clave candidata. Requiere un metodo implementado en el DAO

	public Medidor traerMedidorPorNumero(int nroSerie){
		Medidor c=MedidorDao.getInstance().traerMedidorPorNumero(nroSerie);
		return c;
	}
	
	public int agregar(int nroSerie, Cliente cliente, String direccion, Zona zona, boolean esBaja, String tension) throws Exception{
		if (this.traerMedidorPorNumero(nroSerie)!=null)
	        throw new Exception ("Error. Ya existe un medidor con el nroSerie:" + nroSerie);	
		return MedidorDao.getInstance().agregar(new Medidor(nroSerie, cliente, direccion, zona, esBaja, tension));//devuelve id agregado
	}
	
	public void modificarMedidor (Medidor c) throws Exception{
		
		MedidorDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		if (this.traerMedidor(pk)==null) 
	        throw new Exception ("Error. El medidor no existe");
		MedidorDao.getInstance().eliminar(traerMedidor(pk));
	}
	
	public List<Medidor>traerMedidor(){
		return MedidorDao.getInstance().traerMedidor();
	}
}
