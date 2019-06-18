package test;

import datos.Factura;
import negocio.FacturaABM;

public class testGenerarFactura {

	public static void main(String[] args) {
		System.out.println("\n\n GENERO FACTURA");
		try {
			Factura factura1= FacturaABM.getInstance().generarFactura(12345,05,2019);
			System.out.println(factura1.toString());
			

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
