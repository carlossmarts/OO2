package test;

import negocio.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import datos.*;
import funciones.Funciones;

public class Asd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaDesde = LocalDate.parse("01/05/2019", formato);
		
		System.out.println(fechaDesde);
		
		
		
		
	}

}
