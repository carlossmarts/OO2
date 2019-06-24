package negocio;

import  java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	private static ClienteABM instancia = null;

	public static ClienteABM getInstance (){
		if(instancia == null){
			instancia = new ClienteABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Cliente traerCliente(int idCliente) throws Exception{
		Cliente c= ClienteDao.getInstance().traerCliente(idCliente);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Cliente con el id indicado");
		}
		return c;
	}

	
	

	public Cliente traerCliente(String cuil_cuit) throws Exception{
		Cliente c = ClienteDao.getInstance().traerCliente(cuil_cuit);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no se encontró un cliente con el cuil indicado");
		}
		if(c.isInactivo()) {
			throw new Exception("Error en la capa de negocio, el cliente con el cuil indicado se encuentra Inactivo");
		}
		
		return c;
	}
	
	public int agregar(String cuil_cuit) throws Exception{
		Cliente b = ClienteDao.getInstance().traerCliente(cuil_cuit);
		if(b!=null)
		{
			throw new Exception ("Cliente Duplicado");
		}
		Cliente c = new Cliente(cuil_cuit);
		return ClienteDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarCliente (Cliente c) throws Exception{
		//implementar excepción
		ClienteDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		Cliente c = ClienteDao.getInstance().traerCliente(pk);
		if(c==null)
		{
			throw new Exception ("No Existe Cliente Registrado");
		}
		ClienteDao.getInstance().eliminar(c);
	}
	
	public void BajaLogica (int idCliente) throws Exception{
		Cliente c = ClienteDao.getInstance().traerCliente(idCliente);
		c.setInactivo(true);
		ClienteDao.getInstance().actualizar(c);
	}
	
	
	public List<Cliente>traerClientes(){
		return ClienteDao.getInstance().traerClientes();
	}
	
	public Cliente TraerClienteYContacto(int idCliente){
		return ClienteDao.getInstance().traerClienteYContacto(idCliente);
	}
}
	 