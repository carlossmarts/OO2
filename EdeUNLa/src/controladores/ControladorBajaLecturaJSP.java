package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.LecturaABM;
import negocio.MedidorABM;
import datos.Medidor;
import datos.Lectura;

public class ControladorBajaLecturaJSP extends HttpServlet {
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
			
			Medidor m = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor);
			
			Lectura lectura = LecturaABM.getInstance().traerLectura(m, anio, mes);
			int idLectura = lectura.getIdLectura();
			LecturaABM.getInstance().bajaLogica(idLectura);
			
			lectura = LecturaABM.getInstance().traerLectura(idLectura);
			
			request.setAttribute("lectura", lectura);
			request.getRequestDispatcher("/vistaConsultarLectura.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}
}