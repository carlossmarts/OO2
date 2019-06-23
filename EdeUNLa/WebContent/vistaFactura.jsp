<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocio.ClienteABM"%>
<%@ page import="datos.Factura"%>
<%@ page import="datos.ItemFactura"%>
<%@ page import="funciones.Funciones"%>
<%@ page import="java.time.LocalDate"%>

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
		Factura factura = (Factura) request.getAttribute("factura");
	%>
	<form>
		<div id="muestra">
			<table id="muestra" class="tabla">
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
			</table>
			<center><input type="submit" name="submit" class="btn btn-green"
				value="Imprimir" onclick="javascript:imprimir()"></center>
		</div>
	</form>
	<script>
		function imprimir() {
			var mywindow = window.open('', 'PRINT', 'height=400,width=600');
			mywindow.document.write('<html><head>');
			mywindow.document
					.write('<style>.tabla{width:100%;border-collapse:collapse;margin:16px 0 16px 0;}.tabla th{border:1px solid #ddd;padding:4px;background-color:#d4eefd;text-align:left;font-size:15px;}.tabla td{border:1px solid #ddd;text-align:left;padding:6px;} body {font-family:"Courier New";line-height: 18px;}</style>');
			mywindow.document.write('</head><body >');
			mywindow.document
					.write('<TABLE border="0" width="100%" bgcolor="white"><TR><TD align="left" width="100"><a title="Menu Inicio"href="centro.jsp" target="centro"><IMG src="img/unla.png" height="100" width="100"	border=1></a></TD> <TD align="left"><font color="black"><H1>EdeUNLa</H1><H3>Distribuidora Eléctrica</H3></font></TD>');
			mywindow.document
					.write(document.getElementById('muestra').innerHTML);
			mywindow.document.write('</body></html>');
			mywindow.document.close(); // necesario para IE >= 10
			mywindow.focus(); // necesario para IE >= 10
			mywindow.print();
			mywindow.close();
			window.history.back();
			return true;
		}
	</script>
</BODY>
</html>