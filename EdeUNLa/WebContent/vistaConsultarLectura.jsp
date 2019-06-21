<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.Lectura"%>
<%@ page import="datos.LecturaAltaDemanda"%>
<%@ page import="datos.LecturaBajaDemanda"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EdeUNLa</title>
</head>
<BODY>
	<%
		Lectura l = (Lectura) request.getAttribute("lectura");
	%>
	<div style= "background-color:lightblue">
	
	<%if(l.isInactiva()){ %>
		<br> La lectura solicitada fue dada de baja
	<%} else { %>
		<BR> Lectura 
		<%=l.getIdLectura()%>
		<BR> Medidor numero:
		<%=l.getMedidor().getNroSerie()%>
		<BR> Direccion:
		<%=l.getMedidor().getDireccion()%>
		<BR> Fecha: 
		<%=l.getFecha()%>
		<BR> Inspector nro: 
		<%=l.getInspector().getIdInspector()%>
		
		<%if(l instanceof LecturaBajaDemanda){ %>
			<%LecturaBajaDemanda lbd = (LecturaBajaDemanda) l; %>
			<BR> Consumo: 
			<%=lbd.getConsumo()%>
		<%} else{%>
			<%LecturaAltaDemanda lad = (LecturaAltaDemanda) l; %>
			<BR> Consumo Pico: 
			<%=lad.getConsumoPico()%>
			<BR> Consumo Valle: 
			<%=lad.getConsumoValle()%>
			<BR> Consumo Resto: 
			<%=lad.getConsumoResto()%>
		<%} %>
	<%} %>
		<BR>
	<BR>
	</div>
</BODY>
</html>