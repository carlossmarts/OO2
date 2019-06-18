package test;

import negocio.*;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import datos.*;
import funciones.Funciones;

public class Asd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String desdeFecha = "01/06/2019";
		String hastaFecha = "01/09/2019";
		
		LocalDate fechaDesde = LocalDate.parse(desdeFecha, formatters);
		LocalDate fechaHasta = LocalDate.parse(hastaFecha, formatters);
		
		System.out.println(fechaDesde);
		
		System.out.println("asd"=="asdd");
		*/
	
		
		TarifaIndustrial retorno = null;
		for (TarifaIndustrial t : TarifaIndustrialABM.getInstance().traerTarifaIndustrial()) {
			if (t.getTension().equals("MT") && t.getLimiteConsumo() > 500  && !(t.isConsumoMayor())) {
				retorno = t;
			}
			if (t.getTension().equals("MT") && t.getLimiteConsumo() <= 500  && t.isConsumoMayor()) {
				retorno = t;
			}
		}
		System.out.println(retorno.toString());
		
	}

}
