package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Zona;
import datos.Zona;

public class ZonaDao {

	private static Session session;
	private Transaction tx;
	private static ZonaDao  instancia = null; //patron singleton

	public static ZonaDao getInstance(){
		if (instancia == null){
			instancia = new ZonaDao();
		}	
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ZonaDao", he);
	}

	public int agregar(Zona objeto) {
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

	public void actualizar(Zona objeto) throws HibernateException{
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

	public void eliminar(Zona objeto) throws HibernateException{
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

	public Zona traerZona(int idZona) throws HibernateException{
		Zona objeto = null;
		try {
			iniciaOperacion();
			objeto=(Zona)session.get(Zona.class, idZona);
		}
		finally {
			session.close();
		}
		return objeto;
	}


	//TRAER UN OBJETO POR NOMBRE DE ZONA
	public Zona traerZona(String nombre) throws HibernateException{
		Zona objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Zona z where z.nombre like '%"+nombre+"%'";
			objeto=(Zona)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}

	public Zona traerZonaEInspectores(String nombre){
		Zona objeto = null;
		try {
			iniciaOperacion() ;
			String hql="from Zona z where z.nombre like '%"+nombre+"%'";
			objeto = (Zona) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getInspectores());
		} finally {
			session. close() ;
		}

		return objeto;

	}


	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Zona> traerZona() throws HibernateException{
		List<Zona> lista=null;
		try {
			iniciaOperacion();
			lista=session.createQuery("from zona").list();
		}
		finally {
			session.close();
		}
		return lista;
	}

}
