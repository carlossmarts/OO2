package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.LecturaAltaDemanda;
import datos.Medidor;
import datos.Inspector;
import negocio.InspectorABM;
import negocio.LecturaAltaDemandaABM;
import negocio.MedidorABM;

public class ControladorModificacionLecturaADJSP extends HttpServlet {
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
			int anio = Integer.parseInt(request.getParameter("anio"));
			int mes = Integer.parseInt(request.getParameter("mes"));
			LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
			LocalTime hora = LocalTime.parse(request.getParameter("hora"));
			int inspectorCuil = Integer.parseInt(request.getParameter("inspector"));
			int pico = Integer.parseInt(request.getParameter("pico"));
			int valle = Integer.parseInt(request.getParameter("valle"));
			int resto = Integer.parseInt(request.getParameter("resto"));
			Medidor m = MedidorABM.getInstance().traerMedidorPorNumero(nroMedidor);
			Inspector i = InspectorABM.getInstance().traerInspector(inspectorCuil);
			
			
			LecturaAltaDemanda lad = LecturaAltaDemandaABM.getInstance().traerLecturaAltaDemanda(idLectura);
			lad.setMedidor(m);
			lad.setInspector(i);
			lad.setFecha(fecha);
			lad.setHora(hora);
			lad.setConsumoPico(pico);
			lad.setConsumoValle(valle);
			lad.setConsumoResto(resto);
			
			LecturaAltaDemandaABM.getInstance().modificarLecturaAltaDemanda(lad);
			
			request.setAttribute("lectura", lad);
			request.getRequestDispatcher("/vistaModificacionLectura.jsp").forward(request, response);
		
			
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
		}
	}

}
