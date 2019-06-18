package test;

import datos.Medidor;
import negocio.*;
import funciones.Funciones;

import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Inspector;
import negocio.MedidorABM;
import negocio.ZonaABM;
import negocio.ClienteABM;
import negocio.InspectorABM;
import datos.Zona;

public class TestABMMedidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteABM abmc = new ClienteABM();

		MedidorABM abm = new MedidorABM();

		ZonaABM abmz = new ZonaABM();

		InspectorABM abmi = new InspectorABM();

		try {
			// CREO INSPECTORES
			int id = abmi.agregar("1-23456789-0");// sin lista de zonas por el momento
			int id2 = abmi.agregar("0-12345678-9");// sin lista de zonas por el momento
			Inspector ins = abmi.traerInspector(id);
			Inspector ins2 = abmi.traerInspector(id2);
			// SET DE INSPECTORES
			Set<Inspector> inspectores = new HashSet();
			inspectores.add(ins);
			inspectores.add(ins2);
			// ALTA ZONA
			int idZona = abmz.agregar("Lanus");
			
			Zona z = ZonaABM.getInstance().traerZona(idZona);
			z.setInspectores(inspectores);
			ZonaABM.getInstance().modificarZona(z);
			
			// ALTA CLIENTE
			int idCliente = ClienteABM.getInstance().agregar("20-36161871-9");
			
			
			/* Añadir */
			int idMedidor = abm.agregar(6, ClienteABM.getInstance().traerCliente(1), "calle falsa 123", ZonaABM.getInstance().traerZona(idZona)
									,false,null);
			Medidor medidor = abm.traerMedidor(idMedidor);
			Funciones.print("Medidor " + medidor.getNroSerie() + " Creado");
			/* Modificar */

			Funciones.print("\n\n\n modificar medidor");
			medidor.setNroSerie(3);
			medidor.setEsBaja(true);
			abm.modificarMedidor(medidor);
			Funciones.print("Medidor " + medidor.getNroSerie() + " Modificado");
			
			

			/* Eliminar */

			/*
			 * abm.eliminar(id); Funciones.print("Medidor Eliminado");
			 */

		} catch (Exception e) {

			Funciones.print("Excepcion: " + e.getMessage());
		}
		
		try {
			Medidor medidor = abm.traerMedidor(3);
			Funciones.print("\n\n\n modificar medidor");
			medidor.setNroSerie(3);
			medidor.setEsBaja(true);
			abm.modificarMedidor(medidor);
			Funciones.print("Medidor " + medidor.getNroSerie() + " Modificado");
			
			

			/* Eliminar */

			/*
			 * abm.eliminar(id); Funciones.print("Medidor Eliminado");
			 */

		} catch (Exception e) {

			Funciones.print("Excepcion: " + e.getMessage());
		}

	}

}
