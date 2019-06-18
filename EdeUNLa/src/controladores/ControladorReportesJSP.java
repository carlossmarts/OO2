package controladores;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Cliente;
import datos.Factura;
import negocio.ClienteABM;
import negocio.ContactoABM;
import negocio.FacturaABM;


public class ControladorReportesJSP extends HttpServlet {
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
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			String desdeFecha = request.getParameter("desdeFecha");
			System.out.println(desdeFecha);
			String hastaFecha = request.getParameter("hastaFecha");
			
			LocalDate fechaDesde = LocalDate.parse(desdeFecha, formatters);
			LocalDate fechaHasta = LocalDate.parse(hastaFecha, formatters);
			
			List<Factura>facturas=FacturaABM.getInstance().traerFacturasEntreFechas(fechaDesde, fechaHasta);
			request.setAttribute("facturas", facturas);
			request .getRequestDispatcher( "/vistaReportes.jsp" ).forward( request , response );

		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

}