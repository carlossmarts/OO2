package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import datos.*;
import negocio.*;

public class TestEdeUNLa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CREO UN CLIENTE y CONTACTO
		System.out.println("\n\n CREO CLIENTES y CONTACTOS");
		try {
			int idCliente = ClienteABM.getInstance().agregar("20-36161871-9");
			int idContacto = ContactoABM.getInstance().agregar("A.Barbier 1234", "4235900", "ma@gmail.com",
					ClienteABM.getInstance().traerCliente("20-36161871-9"));
			Cliente c = ClienteABM.getInstance().TraerClienteYContacto(idCliente);
			System.out.println(c.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			int idCliente = ClienteABM.getInstance().agregar("27-36409153-8");
			int idContacto = ContactoABM.getInstance().agregar("mendoza 119", "42942088", "mail@gmail.com",
					ClienteABM.getInstance().traerCliente("27-36409153-8"));
			Cliente c = ClienteABM.getInstance().TraerClienteYContacto(idCliente);
			System.out.println(c.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n AGREGO INSPECTORES Y ZONA");
		try {
			// CREO INSPECTORES
			InspectorABM.getInstance().agregar("0-12345678-9");
			InspectorABM.getInstance().agregar("9-87654321-0");

			// CREO ZONA
			ZonaABM.getInstance().agregar("SUR");

			// AGREGO INSPECTORES A LA ZONA

			Zona z = ZonaABM.getInstance().traerZona("SUR");
			Set<Inspector> inspectoresZona = new HashSet<>();
			inspectoresZona.add(InspectorABM.getInstance().traerInspector(1));
			inspectoresZona.add(InspectorABM.getInstance().traerInspector(2));
			z.setInspectores(inspectoresZona);
			ZonaABM.getInstance().modificarZona(z);

			System.out.println(z.toString());
			for (Inspector i : z.getInspectores()) {
				System.out.println(i.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// CREO TARIFAS
		System.out.println("\n\n CREO TARIFAS");
		try {
		TarifaResidencialABM.getInstance().agregar("T1-R1-0-150", 32.82, 2.653, 0, 150);
		TarifaResidencialABM.getInstance().agregar("T1-R2-151-326", 56.11, 2.651, 151, 325);
		TarifaResidencialABM.getInstance().agregar("T1-R3-326-400", 91.73, 2.705, 326, 400);
		TarifaResidencialABM.getInstance().agregar("T1-R4-401-450", 107.34, 2.785, 401, 450);
		TarifaResidencialABM.getInstance().agregar("T1-R5-450-500", 161.66, 2.864, 451, 500);
		TarifaResidencialABM.getInstance().agregar("T1-R6-501-600", 316, 2.918, 501, 600);
		TarifaResidencialABM.getInstance().agregar("T1-R7-601-700", 850.24, 3.309, 601, 700);
		TarifaResidencialABM.getInstance().agregar("T1-R8-701-1400", 1203.64, 3.411, 701, 1400);
		TarifaResidencialABM.getInstance().agregar("T1-R9 + 1400", 1442.88, 3.437, 1400, -1);
		
		TarifaIndustrialABM.getInstance().agregar("BTMenor", 300, false, "BT", 3226.41, 2.26, 2.061, 2.16);
		TarifaIndustrialABM.getInstance().agregar("BTMayor", 300, true, "BT", 3226.41, 3.286, 2.99, 3.138);
		TarifaIndustrialABM.getInstance().agregar("MTMenor", 300, false, "MT", 3226.09, 2.184, 1.959, 2.053);
		TarifaIndustrialABM.getInstance().agregar("MTMayor", 300, true, "MT", 3226.09, 3.123, 2.841, 2.983);
		TarifaIndustrialABM.getInstance().agregar("ATMenor", 300, false, "AT", 3224.11, 2.060, 1.879, 1.967);
		TarifaIndustrialABM.getInstance().agregar("ATMayor", 300, true, "AT", 3224.11, 2.995, 2.725, 2.860);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// CREO MEDIDORES
		System.out.println("\n\n CREO MEDIDORES");

		try {
			Cliente c1 = ClienteABM.getInstance().traerCliente("20-36161871-9");
			Cliente c2 = ClienteABM.getInstance().traerCliente("27-36409153-8");
			Zona z = ZonaABM.getInstance().traerZona("SUR");
			int idMedidor1 = MedidorABM.getInstance().agregar(12345, c1, "A.Barbier 1234", z, true,"BT");
			int idMedidor2 = MedidorABM.getInstance().agregar(45678, c2, "Mendoza 119", z, false,"MT");

			System.out.println(MedidorABM.getInstance().traerMedidorPorNumero(12345).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println(MedidorABM.getInstance().traerMedidorPorNumero(45678).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// AGREGO LECTURAS
		try {
			System.out.println("\n\n CREO LECTURAS");
			int idLecturaBaja = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 06, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 1000);
			int idLecturaBaja2 = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 04, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 500);
			int idLecturaBaja3 = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 02, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 250);
			int idLecturaAlta = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 06, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 700, 70, 30);
			int idLecturaAlta2 = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 04, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 500, 50, 20);
			int idLecturaAlta3 = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 02, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 400, 40, 10);

			System.out.println(LecturaBajaDemandaABM.getInstance().traerLecturaBajaDemanda(idLecturaBaja).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println(LecturaAltaDemandaABM.getInstance().traerLecturaAltaDemanda(idLecturaAlta).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n Lista de lecturas para el medidor nro: " + 12345);

		for (Lectura l : LecturaBajaDemandaABM.getInstance().traerLecturasBajaDemanda(12345)) {
			System.out.println(l.toString());
		}
		
		System.out.println("\n Lista de lecturas para el medidor nro: " + 45678);

		for (Lectura l : LecturaAltaDemandaABM.getInstance().traerLecturasAltaDemanda(45678)) {
			System.out.println(l.toString());
		}

		// GENERO FACTURA
		System.out.println("\n\n GENERO FACTURA DE MEDIDOR BAJA DEMANDA");
		try {
			Factura factura1 = FacturaABM.getInstance().generarFactura(12345, 7, 2019);
			int idUltimaFactura = FacturaABM.getInstance().agregar(factura1.getNroMedidor(), factura1.getDireccion(),
					factura1.getFecha(), factura1.getTotalPagar(), factura1.getObservaciones(),
					factura1.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura1.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(12345, 07, 2019).toString());

			System.out.println("\n");

			Factura factura2 = FacturaABM.getInstance().generarFactura(12345, 8, 2019);
			idUltimaFactura = FacturaABM.getInstance().agregar(factura2.getNroMedidor(), factura2.getDireccion(),
					factura2.getFecha(), factura2.getTotalPagar(), factura2.getObservaciones(),
					factura2.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura2.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(12345, 8, 2019).toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n\n GENERO FACTURA DE MEDIDOR ALTA DEMANDA");
		try {
			Factura factura1 = FacturaABM.getInstance().generarFactura(45678, 7, 2019);
			int idUltimaFactura = FacturaABM.getInstance().agregar(factura1.getNroMedidor(), factura1.getDireccion(),
					factura1.getFecha(), factura1.getTotalPagar(), factura1.getObservaciones(),
					factura1.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura1.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(45678, 07, 2019).toString());

			System.out.println("\n");

			Factura factura2 = FacturaABM.getInstance().generarFactura(45678, 8, 2019);
			idUltimaFactura = FacturaABM.getInstance().agregar(factura2.getNroMedidor(), factura2.getDireccion(),
					factura2.getFecha(), factura2.getTotalPagar(), factura2.getObservaciones(),
					factura2.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura2.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(45678, 8, 2019).toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
