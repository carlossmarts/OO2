	 
package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Inspector;

public class InspectorDao {
	private static Session session;
	private Transaction tx;
	private static InspectorDao  instancia = null; //patron singleton

	public static InspectorDao getInstance(){
		if (instancia == null){
			instancia = new InspectorDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en InspectorDao", he);
	}
	
	public int agregar(Inspector objeto) {
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
	
	public void actualizar(Inspector objeto) throws HibernateException{
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
	
	public void eliminar(Inspector objeto) throws HibernateException{
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
	
	public Inspector traerInspector(int idInspector) throws HibernateException{
		Inspector objeto = null;
		try {
			iniciaOperacion();
			objeto=(Inspector)session.get(Inspector.class, idInspector);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	
	//Traer por cuil
	public Inspector traerInspector(String cuil) throws HibernateException{
		Inspector objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Inspector i where i.cuil like '%"+cuil+"%'";
			objeto=(Inspector)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	

	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Inspector> traerInspectorYZonas(int idInspector) throws HibernateException{
	List<Inspector> lista=null;
	try {
		iniciaOperacion();
		String hql = "from Inspector i inner join fetch i.zonas where i.idInspector = " + idInspector;
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
}