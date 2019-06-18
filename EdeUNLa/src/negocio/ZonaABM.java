package negocio;

import java.util.List;
import java.util.Set;

import dao.ZonaDao;
import datos.Inspector;
import datos.Zona;

public class ZonaABM {
	private static ZonaABM instancia = null;

	public static ZonaABM getInstance() {
		if (instancia == null) {
			instancia = new ZonaABM();
		}
		return instancia;
	}

	// Traer por clacve primaria

	public Zona traerZona(int idZona) throws Exception {
		Zona c = ZonaDao.getInstance().traerZona(idZona);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Zona con el id indicado");
		}
		return c;
	}
	
	//traer por nombre
	public Zona traerZona(String nombre) throws Exception{
		Zona z = ZonaDao.getInstance().traerZona(nombre);
		if(z == null){
			throw new Exception("error en la capa de negocio, no existe una zona con ese nombre");
		}
		return z;
	}
	
	
	public int agregar(String nombre) throws Exception {
		if(ZonaDao.getInstance().traerZona(nombre) != null){
			throw new Exception("error en la capa de negocio, ya existe una zona con ese nombre");
		}
		Zona c = new Zona(nombre);
		return ZonaDao.getInstance().agregar(c); // devuelve id agregado
	}

	public void modificarZona(Zona c) throws Exception {
		// implementar excepción
		ZonaDao.getInstance().actualizar(c);
	}

	public void eliminar(int pk) throws Exception {
		Zona c = traerZona(pk);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Zona con el id indicado");
		}
		ZonaDao.getInstance().eliminar(c);
	}
	
	

	public List<Zona> traerZona() {
		return ZonaDao.getInstance().traerZona();
	}
}
