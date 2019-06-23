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
<BODY topmargin="22,5">
	<%
		Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>


	<%
		if (cliente.isInactivo()) {
	%>
	<form>
		<table>
			<tr>
				<td>El cliente con cuil/cuit: <%=cliente.getCuil_cuit()%> se
					encuentra inactivo
				</td>
			</tr>
		</table>
	</form>

	<%
		} else {
	%>
	<form action="">
		<table>
			<tr>
				<center>
					<h3>Datos del Cliente</h3>
				</center>
			</tr>
			<tr>
				<td>Cuil_cuit:</td>
				<td><%=cliente.getCuil_cuit()%></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><%=cliente.getContacto().getDireccion()%></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><%=cliente.getContacto().getTelefono()%></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><%=cliente.getContacto().getEmail()%></td>
			</tr>
		</table>
	</form>
	<form action="/EdeUNLa/ModificacionCliente.jsp">
		<table>
			<tr>
				<td>Modificar Cliente:</td>
				<td><input type="text" name="idCliente"
					value="<%=cliente.getIdCliente()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" class="btn btn-green"
					value="Modificar"></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
</BODY>
</html>