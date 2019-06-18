	 
package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Contacto;

public class ContactoDao {
	private static Session session;
	private Transaction tx;
	private static ContactoDao  instancia = null; //patron singleton

	public static ContactoDao getInstance(){
		if (instancia == null){
			instancia = new ContactoDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ContactoDao", he);
	}
	
	public int agregar(Contacto objeto) {
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
	
	public void actualizar(Contacto objeto) throws HibernateException{
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
	
	public void eliminar(Contacto objeto) throws HibernateException{
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
	
		public Contacto traerContacto(int idContacto) throws HibernateException{
			Contacto objeto = null;
			try {
				iniciaOperacion();
				objeto=(Contacto)session.get(Contacto.class, idContacto);
			}
			finally {
				session.close();
			}
			return objeto;
		}
//TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

	public Contacto traerContacto(String telefono) throws HibernateException{
		Contacto objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Contacto c where c.telefono like'%"+telefono+"%'";
			objeto=(Contacto)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
}