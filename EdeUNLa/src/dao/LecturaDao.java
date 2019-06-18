
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lectura;
import datos.Medidor;

public class LecturaDao {
	private static Session session;
	private Transaction tx;
	private static LecturaDao instancia = null; // patron singleton

	public static LecturaDao getInstance() {
		if (instancia == null) {
			instancia = new LecturaDao();
		}
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en LecturaDao", he);
	}

	public int agregar(Lectura objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Lectura objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Lectura objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// TRAER UN OBJETO POR CLAVE PRIMARIA(ID)

	public Lectura traerLectura(int idLectura) throws HibernateException {
		Lectura objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lectura) session.get(Lectura.class, idLectura);
		} finally {
			session.close();
		}
		return objeto;
	}

	// TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

	public List<Lectura> traerLecturas(Medidor medidor) throws HibernateException {
		List<Lectura> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Lectura l inner join fetch l.medidor m where m.nroSerie = " + medidor.getNroSerie();
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Lectura> traerLecturas() throws HibernateException {
		List<Lectura> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Lectura l order by idLectura asc";
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;
	}

}