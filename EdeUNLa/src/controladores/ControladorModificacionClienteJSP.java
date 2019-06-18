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

public class ControladorModificacionClienteJSP extends HttpServlet {
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
			String nuevoCuilCuit = request.getParameter("nuevoCuilCuit");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("e-mail");
			
			Cliente c = ClienteABM.getInstance().traerCliente(cuil_cuit);
			int idCliente = c.getIdCliente();
			c.setCuil_cuit(nuevoCuilCuit);
			ClienteABM.getInstance().modificarCliente(c);
			Contacto co = ContactoABM.getInstance().traerContacto(c.getIdCliente());
			co.setDireccion(direccion);
			co.setTelefono(telefono);
			co.setEmail(email);
			co.setCliente(c);
			ContactoABM.getInstance().modificarContacto(co);
			
			c = ClienteABM.getInstance().traerCliente(nuevoCuilCuit);
			
			
			request.setAttribute("cliente", c);
			request.getRequestDispatcher("/vistaModificacionCliente.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}