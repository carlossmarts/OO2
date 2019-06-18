package negocio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import datos.*;
import negocio.*;

import java.util.ArrayList;
import java.util.HashSet;
import  java.util.List;
import java.util.Set;

import dao.FacturaDao;


public class FacturaABM {
	private static FacturaABM instancia = null;

	public static FacturaABM getInstance (){
		if(instancia == null){
			instancia = new FacturaABM();
		}
		return instancia;
	}


	//Traer por clacve primaria

	public Factura traerFactura(int idFactura) throws Exception{
		Factura c= FacturaDao.getInstance().traerFactura(idFactura);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Factura con el id indicado");
		}
		return c;
	}


	//traer por clave candidata. Requiere un metodo implementado en el DAO

	public Factura traerFactura(int idCliente, LocalDate fecha){
		Factura c = FacturaDao.getInstance().traerFactura(idCliente, fecha);
		return c;
	}

	public int agregar(int nroMedidor, String direccion, LocalDate fecha, double totalPagar,
			String observaciones, int idCliente) throws Exception {
		//Buscar una factura ya existente. No llamo a traerFacturaCompleta porque ya tiene implementada una excepcion
		List<Factura> facturas = FacturaDao.getInstance().traerFacturas();
		Factura retorno = null;
		int i = 0;
		while(i<facturas.size() && retorno == null){
			Factura a = facturas.get(i);
			if(a.getNroMedidor() == nroMedidor && a.getFecha().getMonthValue()==fecha.getMonthValue() &&a.getFecha().getYear()==fecha.getYear()){
				retorno = a;
			}
			i++;
		}
		//----------------------------------
		if (retorno != null){
			throw new Exception ("Error en capa de negocio, ya existe una factura para esa fecha y cliente indicado");
		}
		
		Factura c = new Factura(nroMedidor, direccion, fecha, totalPagar, observaciones, idCliente);
		return FacturaDao.getInstance().agregar(c);					//devuelve id agregado
	}

	public int agregar (Factura f) {
		return FacturaDao.getInstance().agregar(f);					//devuelve id agregado
	}


	public void modificarFactura (Factura c) throws Exception{
		//implementar excepción
		FacturaDao.getInstance().actualizar(c);
	}

	public void eliminar(int idFactura) throws Exception {
		Factura f = traerFactura(idFactura);
		if(f== null) {
			throw new Exception ("Error en la capa de negocio, no existe una factura con el id indicado");
		}
		FacturaDao.getInstance().eliminar(f);
	}

	public Factura traerFacturaEItems(int idFactura){
		Factura c = FacturaDao.getInstance().traerFacturaEItems(idFactura);
		return c;
	}

	public List<Factura>traerFacturas(){
		return FacturaDao.getInstance().traerFacturas();
	}
	
	public List<Factura>traerFacturasEntreFechas(LocalDate desde, LocalDate hasta){
		return FacturaDao.getInstance().traerFacturasEntreFechas(desde, hasta);
	}

	public Factura traerFacturaCompleta(int nroSerie, int mes, int anio) throws Exception{
		
		List<Factura> facturas = FacturaDao.getInstance().traerFacturas();
		Factura retorno = null;
		int i = 0;
		while(i<facturas.size() && retorno == null){
			Factura f = facturas.get(i);
			if(f.getNroMedidor() == nroSerie && f.getFecha().getMonthValue()==mes &&f.getFecha().getYear()==anio){
				retorno = f;
			}
			i++;
		}
		
		if (retorno == null){
			throw new Exception ("Error en capa de negocio, no se encuentra una factura para esa fecha y cliente indicado");
		}
		return retorno;
	}





	// ------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------


	public Factura generarFactura(int nroMedidor, int mes, int anio){
		Factura retorno = null;
		//Generar campos para generar la factura
		//Nro de medidor: se le pasa como parámetro

		Medidor m = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor);

		//Direccion:
		String direccion = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor).getDireccion();

		//Fecha:
		LocalDate fecha = LocalDate.of(anio, mes, 10);


		//Cálculo de Consumos

		Set <ItemFactura> lstItem = new HashSet<>();
		double totalAPagar = 0;

		//Verificar que sea un mes impar
		//Si es impar se genera una nueva factura
		if(mes % 2 != 0){
			LocalDate fechaUltimaLectura = fecha.minus(1,ChronoUnit.MONTHS);
			int mesFechaUltima = fechaUltimaLectura.getMonthValue();
			int anioFechaUltima = fechaUltimaLectura.getYear();
			Lectura ultima = null;
			try {
				ultima = LecturaABM.getInstance().traerLectura(m, anioFechaUltima, mesFechaUltima);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			
			if(m.isEsBaja()){ 												//si es medidor residencial												
				//calcular consumo
				LecturaBajaDemanda lec = (LecturaBajaDemanda) ultima;
				int consumo = LecturaBajaDemandaABM.getInstance().calcularConsumo(lec);
				
				//Obtener tarifa
				TarifaResidencial tarifaR = TarifaResidencialABM.getInstance().traer(consumo);

				//Agregar a los items de factura el monto mínimo, y el consumo
				lstItem.add(new ItemFactura("Cargo fijo", tarifaR.getMontoMinimo(), 1, "fijo",null));
				lstItem.add(new ItemFactura("cargo por consumo", tarifaR.getCargoVariable(), consumo, "KWH",null));

			}
			//Si es industrial
			else {
				//calcular de consumos
				LecturaAltaDemanda lec = (LecturaAltaDemanda) ultima;
				int consumoPico = LecturaAltaDemandaABM.getInstance().calcularConsumoPico(lec);
				int consumoValle = LecturaAltaDemandaABM.getInstance().calcularConsumoValle(lec);
				int consumoResto = LecturaAltaDemandaABM.getInstance().calcularConsumoResto(lec);
				
				int consumoTotal = consumoPico + consumoValle + consumoResto;
				
				//Obtener tarifa
				TarifaIndustrial tarifaI = TarifaIndustrialABM.getInstance().traer(consumoTotal, m.getTension());
				
				//agregar a los item de factura
				lstItem.add(new ItemFactura("cargo fijo", tarifaI.getCargoFijo(), 1, "fijo", null));
				lstItem.add(new ItemFactura("cargo por consumo pico", tarifaI.getCargoVariablePico(), consumoPico, "KWH", null));
				lstItem.add(new ItemFactura("cargo por consumo valle", tarifaI.getCargoVariableValle(), consumoValle, "KWH", null));
				lstItem.add(new ItemFactura("cargo por consumo resto", tarifaI.getCargoVariableResto(), consumoResto, "KWH", null));
			}

			for (ItemFactura i : lstItem){
				totalAPagar += i.calcularSubtotal();
			}

			retorno = new Factura(nroMedidor, direccion, fecha, totalAPagar, "", m.getCliente().getIdCliente());
			retorno.setLstItem(lstItem);

		}

		
		//Si es par se duplica la factura del mes anterior con una nueva fecha
		else{
			LocalDate fechaFacturaAnterior = fecha.minus(1, ChronoUnit.MONTHS);
			int idCliente = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor).getCliente().getIdCliente();
			try{
				Factura nuevaFactura = FacturaABM.getInstance().traerFacturaCompleta(nroMedidor, fechaFacturaAnterior.getMonthValue(),fechaFacturaAnterior.getYear()); //traer anterior
				LocalDate NuevaFecha = nuevaFactura.getFecha().plus(1, ChronoUnit.MONTHS);		//generar fecha nueva
				nuevaFactura.setFecha(NuevaFecha);												//setear fecha a la factura	
				retorno = nuevaFactura;
			}
			catch (Exception e){ 
				System.out.println(e.getMessage());
			}
		}
		return retorno;
	}
}