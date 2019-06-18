package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.LecturaAltaDemanda;
import datos.LecturaBajaDemanda;


public class LecturaBajaDemandaDao {

	private static Session session;
	private Transaction tx;
	private static LecturaBajaDemandaDao  instancia = null; //patron singleton

	public static LecturaBajaDemandaDao getInstance(){
		if (instancia == null){
			instancia = new LecturaBajaDemandaDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en LecturaBajaDemandaDao", he);
	}
	
	public int agregar(LecturaBajaDemanda objeto) {
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
	
	public void actualizar(LecturaBajaDemanda objeto) throws HibernateException{
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
	
	public void eliminar(LecturaBajaDemanda objeto) throws HibernateException{
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
	
	public LecturaBajaDemanda traerLecturaBajaDemanda(long idLecturaBajaDemanda) throws HibernateException{
		LecturaBajaDemanda objeto = null;
		try {
			iniciaOperacion();
			objeto=(LecturaBajaDemanda)session.get(LecturaBajaDemanda.class, idLecturaBajaDemanda);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER LISTA DE OBJETOS (USA HQL)

	//TRAER LISTA DE LECTURAQS DE UN MEDIDOR (USA HQL)

		public List<LecturaBajaDemanda> traerLecturaBajaDemanda(int nroSerie) throws HibernateException{
		List<LecturaBajaDemanda> lista=null;
		try {
			iniciaOperacion();
			String hql = "from LecturaBajaDemanda l inner join fetch l.medidor m where m.nroSerie = " + nroSerie;
			lista=session.createQuery(hql).list();
		}
		finally {
			session.close();
		}
		return lista;
		}
		
		
		

	
}
