package funciones;

import java.time.LocalDate;

public class Funciones {

	public static void print(String arg) {
		System.out.println (arg);
	}
	
	//FUNCIONES PARA LOCAL DATE
	
	public static String traerFechaCorta(LocalDate d){
		return(d.getDayOfMonth()+"/"+d.getMonth()+"/"+d.getYear());
	}
	
	/* ******************************** AMB genérico ********************************
	 
package negocio;

import  java.util.List;
import dao.ClaseDao;
import datos.Clase;

public class ClaseABM {
	private static ClaseABM instancia = null;

	public ClaseABM getInstance (){
		if(instancia == null){
			instancia = new ClaseABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Clase traerClase(long idClase) throws Exception{
		Clase c= ClaseDao.getInstance().traerClase(idClase);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe clase con el id indicado");
		}
		return c;
	}

	
	//traer por clave candidata. Requiere un metodo implementado en el DAO

	public Clase traerClase(tipoAtrib atrib){
		Clase c=ClaseDao.getInstance().traerClase(atrib);
		return c;
	}
	
	public int agregar(Atributos necesarios para el constructor) throws Exception{
		//Implementar excepcion segun requiera el problema
		Clase c = new Clase(atributos del constructor);
		return ClaseDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarClase (Clase c) throws Exception{
		//implementar excepción
		ClaseDao.getInstance().actualizar(c);
	}
	
	public void eliminar(long pk) throws Exception {
		Clase c = traerClase(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe clase con el id indicado");
		}
		ClaseDao.getInstance().eliminar(c);
	}
	
	public List<Clase>traerClase(){
		return ClaseDao.getInstance().traerClase();
	}
}
	 
	 ********************************************************************************/
	
	/* ******************************** DAO genérico ********************************
	 
package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.clase;

public class ClaseDao {
	private static Session session;
	private Transaction tx;
	private static ClaseDao  instancia = null; //patron singleton

	public static ClaseDao getInstance(){
		if (instancia == null){
			instancia = new ClaseDao();
		}	
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException{
		session=HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos en ClaseDao", he);
	}
	
	public int agregar(Clase objeto) {
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
	
	public void actualizar(Clase objeto) throws HibernateException{
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
	
	public void eliminar(Clase objeto) throws HibernateException{
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
	
	public Clase traerClase(long idClase) throws HibernateException{
		Clase objeto = null;
		try {
			iniciaOperacion();
			objeto=(Clase)session.get(Clase.class, idClase);
		}
		finally {
			session.close();
		}
		return objeto;
	}
	

	//TRAER UN OBJETO POR CLAVE CANDIDATA (USA HQL)

	public Clase traerClase(tipoAtrib atrib) throws HibernateException{
		Clase objeto=null;
		try {
			iniciaOperacion();
			String hql = "from clase c where c.atrib = " + atrib;
			objeto=(Clase)session.createQuery(hql).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	//TRAER LISTA DE OBJETOS (USA HQL)

	@SuppressWarnings("unchecked")
	public List<Clase> traerClase() throws HibernateException{
	List<Clase> lista=null;
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
	 
	 ********************************************************************************/
	

	
}