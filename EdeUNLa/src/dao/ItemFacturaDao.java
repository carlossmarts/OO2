	 
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemFactura;

public class ItemFacturaDao {
	private static Session session;
	private Transaction tx;
	private static ItemFacturaDao  instancia = null; //patron singleton

	public static ItemFacturaDao getInstance(){
		if (instancia == null){
			instancia = new ItemFacturaDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ItemFacturaDao", he);
	}
	
	public int agregar(ItemFactura objeto) {
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
	
	public void actualizar(ItemFactura objeto) throws HibernateException{
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
	
	public void eliminar(ItemFactura objeto) throws HibernateException{
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
	
	public ItemFactura traerItemFactura(long idItemFactura) throws HibernateException{
		ItemFactura objeto = null;
		try {
			iniciaOperacion();
			objeto=(ItemFactura)session.get(ItemFactura.class, idItemFactura);
		}
		finally {
			session.close();
		}
		return objeto;
	}
}
	 