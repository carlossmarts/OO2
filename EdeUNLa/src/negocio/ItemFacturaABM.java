	 
package negocio;


import java.util.Set;
import dao.ItemFacturaDao;
import datos.Factura;
import datos.ItemFactura;

public class ItemFacturaABM {
	private static ItemFacturaABM instancia = null;

	public static ItemFacturaABM getInstance (){
		if(instancia == null){
			instancia = new ItemFacturaABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public ItemFactura traerItemFactura(long idItemFactura) throws Exception{
		ItemFactura c= ItemFacturaDao.getInstance().traerItemFactura(idItemFactura);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe ItemFactura con el id indicado");
		}
		return c;
	}

	
	
	public int agregar(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) throws Exception{
		//Implementar excepcion segun requiera el problema
		ItemFactura c = new ItemFactura(detalle, precioUnitario, cantidad, unidad, factura);
		return ItemFacturaDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarItemFactura (ItemFactura c) throws Exception{
		//implementar excepción
		ItemFacturaDao.getInstance().actualizar(c);
	}
	
	public void eliminar(long pk) throws Exception {
		ItemFactura c = traerItemFactura(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe ItemFactura con el id indicado");
		}
		ItemFacturaDao.getInstance().eliminar(c);
	}
	
	public void agregar(Set<ItemFactura> lstItem, Factura f){
		for (ItemFactura i : lstItem){
			try{
				agregar(i.getDetalle(), i.getPrecioUnitario(), i.getCantidad(), i.getUnidad(), f);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}