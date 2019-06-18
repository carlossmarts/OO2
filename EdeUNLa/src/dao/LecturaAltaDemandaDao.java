package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.LecturaAltaDemanda;
import datos.Medidor;


public class LecturaAltaDemandaDao {

	private static Session session;
	private Transaction tx;
	private static LecturaAltaDemandaDao  instancia = null; //patron singleton

	public static LecturaAltaDemandaDao getInstance(){
		if (instancia == null){
			instancia = new LecturaAltaDemandaDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en LecturaAltaDemandaDao", he);
	}
	
	public int agregar(LecturaAltaDemanda objeto) {
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
	
	public void actualizar(LecturaAltaDemanda objeto) throws HibernateException{
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
	
	public void eliminar(LecturaAltaDemanda objeto) throws HibernateException{
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
	
	public LecturaAltaDemanda traerLecturaAltaDemanda(long idLecturaAltaDemanda) throws HibernateException{
		LecturaAltaDemanda objeto = null;
		try {
			iniciaOperacion();
			objeto=(LecturaAltaDemanda)session.get(LecturaAltaDemanda.class, idLecturaAltaDemanda);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	
	//TRAER LISTA DE LECTURAQS DE UN MEDIDOR (USA HQL)

	public List<LecturaAltaDemanda> traerLecturaAltaDemanda(int nroSerie) throws HibernateException{
	List<LecturaAltaDemanda> lista=null;
	try {
		iniciaOperacion();
		String hql = "from LecturaAltaDemanda l inner join fetch l.medidor m where m.nroSerie = " + nroSerie;
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
	
	
	
}
