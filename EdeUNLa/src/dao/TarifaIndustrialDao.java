package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TarifaIndustrial;
import datos.TarifaResidencial;

public class TarifaIndustrialDao {
	private static Session session;
	private Transaction tx;
	private static TarifaIndustrialDao  instancia = null; //patron singleton

	public static TarifaIndustrialDao getInstance(){
		if (instancia == null){
			instancia = new TarifaIndustrialDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en TarifaIndustrialDao", he);
	}
	
	public int agregar(TarifaIndustrial objeto) {
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
	
	public void actualizar(TarifaIndustrial objeto) throws HibernateException{
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
	
	public void eliminar(TarifaIndustrial objeto) throws HibernateException{
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
	
	public TarifaIndustrial traerTarifaIndustrial(int idTarifaIndustrial) throws HibernateException{
		TarifaIndustrial objeto = null;
		try {
			iniciaOperacion();
			objeto=(TarifaIndustrial)session.get(TarifaIndustrial.class, idTarifaIndustrial);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	public TarifaIndustrial traerTarifaIndustrial(String codigo) throws HibernateException{
		TarifaIndustrial objeto=null;
		try {
			iniciaOperacion();
			String hql = "from TarifaIndustrial t where t.codigo like '%"+codigo+"%'";
			objeto=(TarifaIndustrial)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<TarifaIndustrial> traerTarifaIndustrial() throws HibernateException{
	List<TarifaIndustrial> lista=null;
	try {
		iniciaOperacion();
		String hql = "from TarifaIndustrial t order by t.idTarifa";
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
}
