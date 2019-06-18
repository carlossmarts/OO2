package test;

import negocio.ClienteABM;
import negocio.ContactoABM;
import datos.Cliente;
import datos.Contacto;
import funciones.Funciones;

public class TestABMClienteYContacto {
	public static void main(String[] args) throws Exception {
		String cuil_cuit = "20-41716615-6";
		String direccion = "A. Barbier 2746";
		String telefono = "1158700943";
		String email = "mvelasquez@gmail.com";
		ClienteABM abm = new ClienteABM();
		ContactoABM abmc = new ContactoABM();
		try {
// AGREGO CLIENTE Y SU CONTACTO
			int id = abm.agregar(cuil_cuit);// El metodo agregar me devuelve su id
			Cliente cliente = abm.traerCliente(id);
			System.out.println(cliente.toString());

		} catch (Exception e) {

			System.out.println("Excepcion: " + e.getMessage());
		}
		try {
			Cliente cli = ClienteABM.getInstance().traerCliente(cuil_cuit);
			abmc.agregar(direccion, telefono, email, cli);
			System.out.println("Cliente" + cli.getCuil_cuit() + " Agregado");
			cli.setCuil_cuit("20-41716615-9");
			abm.modificarCliente(cli);
			System.out.println("CLiente" + cli.getCuil_cuit() + " Modificado");
			/*
			 * abm.eliminar(id); System.out.println("CLiente Eliminado");
			 */
		} catch (

		Exception e) {

			System.out.println("Excepcion: " + e.getMessage());
		}
		
	}
}