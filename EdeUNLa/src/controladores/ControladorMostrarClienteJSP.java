package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;
import datos.Cliente;

public class ControladorMostrarClienteJSP extends HttpServlet {
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
			ClienteABM clienteabm = ClienteABM.getInstance();
			Cliente cliente = clienteabm.traerCliente(cuil_cuit);
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("/vistaCliente.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}