package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	private static ClienteDao  instancia = null; //patron singleton

	public static ClienteDao getInstance(){
		if (instancia == null){
			instancia = new ClienteDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ClienteDao", he);
	}
	
	public int agregar(Cliente objeto) {
		int id=0;
		try {
			iniciaOperacion();
			id= Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Cliente objeto) throws HibernateException{
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	
	public void eliminar(Cliente objeto) throws HibernateException{
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
	}
	

	//TRAER UN OBJETO POR CLAVE PRIMARIA(ID)
	
	public Cliente traerCliente(int idCliente) throws HibernateException{
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto=(Cliente)session.get(Cliente.class, idCliente);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

	public Cliente traerCliente(String cuil_cuit) throws HibernateException{
		Cliente objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.cuil_cuit like '%"+cuil_cuit+"%'";
			objeto=(Cliente)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Cliente> traerClientes() throws HibernateException{
	List<Cliente> lista=null;
	try {
		iniciaOperacion();
		String hql = "from Cliente c order by c.idCliente asc";
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
	public Cliente traerClienteYContacto(int idCliente){
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c inner join fetch c.contacto co order by c.idCliente asc";
			objeto=(Cliente) session.createQuery(hql).uniqueResult();
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
}
	 