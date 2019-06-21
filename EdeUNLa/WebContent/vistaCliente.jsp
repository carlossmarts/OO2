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
<BODY bgcolor="#900028">
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
	<div style= "background-color:lightblue">
	
	<%if(cliente.isInactivo()){ %>
		<br> El cliente con cuil/cuit: <%=cliente.getCuil_cuit() %> se encuentra inactivo 
	
	<%}else{ %>
	<BR> Datos del Cliente </BR>
	<BR> Cuil_cuit:
	<%=cliente.getCuil_cuit()%>
	<BR> Direccion :
	<%=cliente.getContacto().getDireccion()%>
	<BR> Telefono :
	<%=cliente.getContacto().getTelefono()%>
	<BR> email :
	<%=cliente.getContacto().getEmail()%>
	<BR>
	<form action="/EdeUNLa/ModificacionCliente.jsp">
			Modificar Cliente: 
			<input type="text" name="idCliente" value="<%=cliente.getIdCliente()%>" readonly="readonly">
			<br>
			<input type="submit" name="Submit" value="Modificar">
		</form>
	<%} %>
	<BR>
	</div>
	
	<div style= "background-color:lightblue">
		
	<BR>
	</div>
</BODY>
</html>