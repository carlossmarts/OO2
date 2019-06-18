<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="datos.Factura"%>
<%@page import="datos.Cliente"%>
<%@page import="datos.ItemFactura"%>
<%@page import="negocio.ClienteABM"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<title>Facturacion</title>
</head>
<body>

	<%@ include file="/cabecera.jsp"%>
	<%List<Factura> facturas =(List)request.getAttribute("facturas");%>
	<%for (Factura factura : facturas) {
		%>
	<form>
		<table>
			<caption align="left">
				<center>Factura-EdeUNLa</center>
			</caption>
			<tr>
				<td>N° Factura:</td>
				<td><%=factura.getIdFactura()%></td>
			</tr>
			<tr>
				<td>Fecha:</td>
				<td><%=factura.getFecha()%></td>
			</tr>
			<tr>
				<td>Cliente:</td>
				<td><%=factura.getIdCliente()%></td>
			</tr>
			<tr>
				<td>Cuil/Cuit:</td>
				<td><%=ClienteABM.getInstance().traerCliente(factura.getIdCliente()).getCuil_cuit()%></td>
			</tr>
			<tr>
				<td>N° Medidor:</td>
				<td><%=factura.getNroMedidor()%></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><%=factura.getDireccion()%></td>
			</tr>
			<tr>
				<td>Detalle</td>
				<td>
					<%
							for (ItemFactura i : factura.getLstItem()) {
						%> <BR><%=i.toString()%> <%
							}
						%>
				</td>
			</tr>
			<tr>
				<td>Total a pagar:</td>
				<td><%=factura.getTotalPagar()%></td>
			</tr>
			<BR>
			<BR>
		</table>
	</form>
	<%
			}
		%>
	<BR>
	</div>
	<A href="/EdeUNLa/index.jsp"> Volver... </A>
</body>
</html>
