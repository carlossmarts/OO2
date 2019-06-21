package controladores;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Factura;
import negocio.ClienteABM;
import negocio.ContactoABM;
import negocio.FacturaABM;
import negocio.ItemFacturaABM;


public class ControladorGenerarFacturaJSP extends HttpServlet {
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

			int nroMedidor = Integer.parseInt(request.getParameter("nroMedidor"));
			int anio = Integer.parseInt(request.getParameter("anio"));
			int mes = Integer.parseInt(request.getParameter("mes"));


			Factura factura = FacturaABM.getInstance().generarFactura(nroMedidor, mes, anio);
			int idFactura = FacturaABM.getInstance().agregar(factura.getNroMedidor(), factura.getDireccion(),
					factura.getFecha(), factura.getTotalPagar(), factura.getObservaciones(),
					factura.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura.getLstItem(), FacturaABM.getInstance().traerFactura(idFactura));
			
			factura = FacturaABM.getInstance().traerFacturaCompleta(nroMedidor, mes, anio);
			

			request.setAttribute("factura", factura);
			request.getRequestDispatcher("/vistaFactura.jsp").forward(request, response);


		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

}
