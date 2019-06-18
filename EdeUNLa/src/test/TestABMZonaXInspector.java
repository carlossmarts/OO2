package test;

import datos.Lectura;
import datos.Inspector;
import datos.Medidor;
import datos.LecturaBajaDemanda;
import datos.LecturaAltaDemanda;
import negocio.LecturaAltaDemandaABM;
import negocio.LecturaBajaDemandaABM;
import negocio.LecturaABM;
import negocio.InspectorABM;
import datos.Inspector;
import negocio.MedidorABM;
import funciones.Funciones;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import datos.Zona;
import negocio.ZonaABM;
import datos.TarifaResidencial;
import datos.TarifaIndustrial;
import datos.Tarifa;
import negocio.TarifaIndustrialABM;
import negocio.TarifaResidencialABM;


public class TestABMZonaXInspector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1) Agregar y mostrar inspectores y zonas

		System.out.println("AGREGAR ZONAS E INSPECTORES\n\n");
		
		System.out.println("\nAgregar y mostrar inspectores");
		try {
			int idInspector1 = InspectorABM.getInstance().agregar("1-23456789-0");// sin lista de zonas por el momento
			int idInspector2 = InspectorABM.getInstance().agregar("0-12345678-9");// sin lista de zonas por el momento
		}	
		catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			System.out.println(InspectorABM.getInstance().traerInspector("1-23456789-0"));
			System.out.println(InspectorABM.getInstance().traerInspector("0-12345678-9"));
		}	
		catch (Exception e){
			System.out.println(e.getMessage());
		}


		System.out.println("\nAgregar y mostrar zonas");
		
		try {
			int idZona1 = ZonaABM.getInstance().agregar("Lanus");
			int idZona2 = ZonaABM.getInstance().agregar("Lomas");
		}	
		catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			System.out.println(ZonaABM.getInstance().traerZona("Lanus"));
			System.out.println(ZonaABM.getInstance().traerZona("Lomas"));
		}	
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nAgregar establecer relaciones zona/Inspector");
		
		Set <Inspector> inspectores = new HashSet<>();
		Set <Zona> zonas = new HashSet<>();
		
		try{
			inspectores.add(InspectorABM.getInstance().traerInspector(1));
			inspectores.add(InspectorABM.getInstance().traerInspector(2));
			zonas.add(ZonaABM.getInstance().traerZona(1));
			zonas.add(ZonaABM.getInstance().traerZona(2));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Inspector i = InspectorABM.getInstance().traerInspector(1);
			i.setZonas(zonas);
			InspectorABM.getInstance().modificarInspector(i);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Inspector i = InspectorABM.getInstance().traerInspector(2);
			i.setZonas(zonas);
			InspectorABM.getInstance().modificarInspector(i);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Zona z = ZonaABM.getInstance().traerZona(1);
			z.setInspectores(inspectores);
			ZonaABM.getInstance().modificarZona(z);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Zona z = ZonaABM.getInstance().traerZona(2);
			z.setInspectores(inspectores);
			ZonaABM.getInstance().modificarZona(z);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n\n Mostrar zonas con sus inspectores e inspectores con sus zonas");
		
		try{
			Zona z = ZonaABM.getInstance().traerZona(2);
			System.out.println(z.toString());
			System.out.println("\n Inspectores: \n");
			for(Inspector i : z.getInspectores()){
				System.out.println(i.toString());
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Inspector i = InspectorABM.getInstance().traerInspector(1);
			System.out.println(i.toString());
			System.out.println("Zonas en las que trabaja");
			for(Zona z : i.getZonas()){
				System.out.println(z.toString());
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


}
