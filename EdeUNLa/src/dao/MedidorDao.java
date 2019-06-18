package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Medidor;


public class MedidorDao {

	private static Session session;
	private Transaction tx;
	private static MedidorDao  instancia = null; //patron singleton

	public static MedidorDao getInstance(){
		if (instancia == null){
			instancia = new MedidorDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en MedidorDao", he);
	}
	
	public int agregar(Medidor objeto) {
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
	
	public void actualizar(Medidor objeto) throws HibernateException{
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
	
	public void eliminar(Medidor objeto) throws HibernateException{
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
	
	public Medidor traerMedidor(int idMedidor) throws HibernateException{
		Medidor objeto = null;
		try {
			iniciaOperacion();
			objeto=(Medidor)session.get(Medidor.class, idMedidor);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

	public Medidor traerMedidorPorNumero(int nroSerie) throws HibernateException{
		Medidor objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Medidor m inner join fetch m.cliente c "
					+ "inner join fetch m.zona z where m.nroSerie = " + nroSerie;
			objeto=(Medidor)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Medidor> traerMedidor() throws HibernateException{
	List<Medidor> lista=null;
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
