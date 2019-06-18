package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;
import negocio.ContactoABM;
import datos.Cliente;
import datos.Contacto;

public class ControladorBajaClienteJSP extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String cuil_cuit = request.getParameter("cuil_cuit");
			Cliente cliente = ClienteABM.getInstance().traerCliente(cuil_cuit);
			Cliente aux = new Cliente();
			aux.setCuil_cuit(cliente.getCuil_cuit());
			int idCliente = cliente.getIdCliente();
			
			ContactoABM.getInstance().eliminar(idCliente);
			
			ClienteABM.getInstance().eliminar(idCliente);
		
			
			request.setAttribute("cliente", aux);
			request.getRequestDispatcher("/vistaBajaCliente.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}