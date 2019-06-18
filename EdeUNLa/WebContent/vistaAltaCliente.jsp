<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="datos.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EdeUNLa</title>
</head>
<BODY>
	<%@include file="/cabecera.jsp"%>
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
	<form>
		<table>
			<BR> Nuevo cliente agregado

			<tR>
			<td>Cuil_cuit:</td><td>
			<%=cliente.getCuil_cuit()%></td></tR>
			<tr> <td>Direccion :</td><td>
			<%=cliente.getContacto().getDireccion()%></td></tr> 
			<tr><td>Telefono :</td><td>
			<%=cliente.getContacto().getTelefono()%></td></tr> 
			<tr><td> email :</td><td>
			<%=cliente.getContacto().getEmail()%></td></tr> 
			<BR>
			<BR>
		</table>
	</form>
	<A href="/EdeUNLa/index.jsp"> Volver... </A>
</BODY>
</html>