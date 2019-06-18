package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class ControladorAltaClienteJSP extends HttpServlet {
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
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("e-mail");
			int idNuevoCliente = ClienteABM.getInstance().agregar(cuil_cuit);
			Cliente cliente = ClienteABM.getInstance().traerCliente(idNuevoCliente);
			int idNuevoContacto = ContactoABM.getInstance().agregar(direccion, telefono, email,cliente );
			
			//Ver qué hacer si no se agrega (idNuevoCliente = 0)
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/vistaAltaCliente.jsp").forward(request, response);
		
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

}
