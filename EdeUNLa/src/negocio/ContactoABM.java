package negocio;

import java.util.List;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	private static ContactoABM instancia = null;

	public static ContactoABM getInstance() {
		if (instancia == null) {
			instancia = new ContactoABM();
		}
		return instancia;
	}

	// Traer por clacve primaria

	public Contacto traerContacto(int idContacto) throws Exception {
		Contacto c = ContactoDao.getInstance().traerContacto(idContacto);
		if (c == null) {
			throw new Exception("Error en la capa de negocio, no existe Contacto con el id indicado");
		}
		return c;
	}

	// traer por clave candidata. Requiere un metodo implementado en el DAO

	public Contacto traerContacto(String telefono) {
		return ContactoDao.getInstance().traerContacto(telefono);

	}

	public int agregar(String direccion, String telefono, String email, Cliente cliente) throws Exception {
		// Implementar excepcion segun requiera el problema
		Contacto c = new Contacto(direccion, telefono, email, cliente);
		cliente.setContacto(c);
		ClienteABM.getInstance().modificarCliente(cliente);
		return ContactoDao.getInstance().agregar(c); // devuelve id agregado
	}

	public void modificarContacto(Contacto c) throws Exception {
		// implementar excepción
		ContactoDao.getInstance().actualizar(c);
	}

	public void eliminar(int id) throws Exception {
		Contacto c = traerContacto(id);
		// implementar excepción
		ContactoDao.getInstance().eliminar(c);
	}
}
