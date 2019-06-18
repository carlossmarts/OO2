package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Tarifa;


public class TarifaDao {
	private static Session session;
	private Transaction tx;
	private static TarifaDao  instancia = null; //patron singleton

	public static TarifaDao getInstance(){
		if (instancia == null){
			instancia = new TarifaDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en TarifaDao", he);
	}
	
	public int agregar(Tarifa objeto) {
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
	
	public void actualizar(Tarifa objeto) throws HibernateException{
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
	
	public void eliminar(Tarifa objeto) throws HibernateException{
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
	
	public Tarifa traerTarifa(long idTarifa) throws HibernateException{
		Tarifa objeto = null;
		try {
			iniciaOperacion();
			objeto=(Tarifa)session.get(Tarifa.class, idTarifa);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

/*	public Tarifa traerTarifa(tipoAtrib atrib) throws HibernateException{
		Tarifa objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Tarifa c where c.atrib = " + atrib;
			objeto=(Tarifa)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
*/	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Tarifa> traerTarifa() throws HibernateException{
	List<Tarifa> lista=null;
	try {
		iniciaOperacion();
		String hql = "";
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}

}
