package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.LecturaBajaDemanda;
import datos.Medidor;
import datos.Inspector;
import negocio.InspectorABM;
import negocio.LecturaBajaDemandaABM;
import negocio.MedidorABM;

public class ControladorModificacionLecturaBDJSP extends HttpServlet {
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
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			int idLectura = Integer.parseInt(request.getParameter("idLectura"));
			
			int nroMedidor = Integer.parseInt(request.getParameter("nroMedidor"));
			LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
			LocalTime hora = LocalTime.parse(request.getParameter("hora"));
			String inspectorCuil = request.getParameter("inspector");
			int consumo = Integer.parseInt(request.getParameter("consumo"));
			Medidor m = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor);
			Inspector i = InspectorABM.getInstance().traerInspector(inspectorCuil);
			
			
			LecturaBajaDemanda lbd = LecturaBajaDemandaABM.getInstance().traerLecturaBajaDemanda(idLectura);
			lbd.setMedidor(m);
			lbd.setInspector(i);
			lbd.setFecha(fecha);
			lbd.setHora(hora);
			lbd.setConsumo(consumo);
			
			LecturaBajaDemandaABM.getInstance().modificarLecturaBajaDemanda(lbd);
			
			request.setAttribute("lectura", lbd);
			request.getRequestDispatcher("/vistaModificacionLectura.jsp").forward(request, response);
		
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

}
