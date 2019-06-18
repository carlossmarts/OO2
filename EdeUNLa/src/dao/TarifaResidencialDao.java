package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaResidencial;
import datos.TarifaResidencial;

public class TarifaResidencialDao {
	private static Session session;
	private Transaction tx;
	private static TarifaResidencialDao  instancia = null; //patron singleton

	public static TarifaResidencialDao getInstance(){
		if (instancia == null){
			instancia = new TarifaResidencialDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en TarifaResidencialDao", he);
	}
	
	public int agregar(TarifaResidencial objeto) {
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
	
	public void actualizar(TarifaResidencial objeto) throws HibernateException{
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
	
	public void eliminar(TarifaResidencial objeto) throws HibernateException{
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
	
	public TarifaResidencial traerTarifaResidencial(int idTarifaResidencial) throws HibernateException{
		TarifaResidencial objeto = null;
		try {
			iniciaOperacion();
			objeto=(TarifaResidencial)session.get(TarifaResidencial.class, idTarifaResidencial);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	
	//traer por codigo
	public TarifaResidencial traerTarifaResidencial(String codigo) throws HibernateException{
		TarifaResidencial objeto=null;
		try {
			iniciaOperacion();
			String hql = "from TarifaResidencial t where t.codigo like '%"+codigo+"%'";
			objeto=(TarifaResidencial)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<TarifaResidencial> traerTarifaResidencial() throws HibernateException{
	List<TarifaResidencial> lista=null;
	try {
		iniciaOperacion();
		String hql = "from TarifaResidencial t order by t.idTarifa";
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
	
}

