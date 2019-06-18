package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Factura;
import java.time.LocalDate;

public class FacturaDao {
	private static Session session;
	private Transaction tx;
	private static FacturaDao  instancia = null; //patron singleton

	public static FacturaDao getInstance(){
		if (instancia == null){
			instancia = new FacturaDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en FacturaDao", he);
	}
	
	public int agregar(Factura objeto) {
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
	
	public void actualizar(Factura objeto) throws HibernateException{
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
	
	public void eliminar(Factura objeto) throws HibernateException{
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
	
	public Factura traerFactura(int idFactura) throws HibernateException{
		Factura objeto = null;
		try {
			iniciaOperacion();
			objeto=(Factura)session.get(Factura.class, idFactura);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER UN OBJETO POR CLAVE CLIENTE Y FECHA(USA HQL)

	public Factura traerFactura(int idCliente, LocalDate fecha) throws HibernateException{
		Factura objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Factura c where c.idCliente = " + idCliente + "and c.fecha = " + fecha;
			objeto=(Factura)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	
	
	public Factura traerFacturaEItems(int idFactura) throws HibernateException{
		Factura objeto=null;
		try {
			iniciaOperacion();
			String hql = "from Factura f where f.idFactura = " + idFactura;
			objeto=(Factura)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getLstItem());
			
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Factura> traerFacturas() throws HibernateException{
	List<Factura> lista=null;
	try {
		iniciaOperacion();
		String hql = "from Factura f order by f.idFactura asc";
		lista=session.createQuery(hql).list();
	}
	finally {
		session.close();
	}
	return lista;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

		@SuppressWarnings("unchecked")
		public List<Factura> traerFacturasEntreFechas(LocalDate desde, LocalDate hasta) throws HibernateException{
		List<Factura> lista=null;
		try {
			iniciaOperacion();
			String hql = "from Factura f where f.fecha>=:desde and f.fecha<=:hasta order by f.idFactura asc";
			lista=session.createQuery(hql).setParameter("desde",desde).setParameter("hasta",hasta).list();
		}
		finally {
			session.close();
		}
		return lista;
		}
	

	
}