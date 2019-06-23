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

	<%
		if (l.isInactiva()) {
	%>
	<form>
		<table>
			<tr>
				<td>La lectura solicitada fue dada de baja</td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	<form>
		<table>
			<tr>
				<td>Lectura</td>
				<td><%=l.getIdLectura()%></td>
			</tr>
			<tr>
				<td>Medidor numero:</td>
				<td><%=l.getMedidor().getNroSerie()%></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><%=l.getMedidor().getDireccion()%></td>
			</tr>
			<tr>
				<td>Fecha:</td>
				<td><%=l.getFecha()%></td>
			</tr>
			<tr>
				<td>Inspector:</td>
				<td><%=l.getInspector().getIdInspector()%></td>
			</tr>
			<%
				if (l instanceof LecturaBajaDemanda) {
			%>
			<%
				LecturaBajaDemanda lbd = (LecturaBajaDemanda) l;
			%>
			<tr>
				<td>Consumo:</td>
				<td><%=lbd.getConsumo()%></td>
			</tr>
		</table>
	</form>
	<form action="/EdeUNLa/ModificacionLecturaBD.jsp">
		<table>
			<tr>
				Modificar Lectura:
				<input type="text" name="idLectura" value="<%=lbd.getIdLectura()%>"
					readonly="readonly">
				<input type="submit" name="Submit" value="Modificar">
		</table>
	</form>
	<%
		} else {
	%>
	<%
		LecturaAltaDemanda lad = (LecturaAltaDemanda) l;
	%>
	<form action="">
		<table>
			<tr>
				<td>Consumo Pico:</td>
				<td><%=lad.getConsumoPico()%></td>
			</tr>
			<tr>
				<td>Consumo Valle:</td>
				<td><%=lad.getConsumoValle()%></td>
			</tr>
			<tr>
				<td>Consumo Resto:</td>
				<td><%=lad.getConsumoResto()%></td>
			</tr>
		</table>
	</form>
	<form action="/EdeUNLa/ModificacionLecturaAD.jsp">
		<table>
			<tr>
				<td>Modificar Lectura:</td>
				<td><input type="text" name="idLectura"
					value="<%=lad.getIdLectura()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><td><input type="submit" class="btn btn-green" name="Submit"
					value="Modificar"></td></td>
			</tr>
		</table>
	</form>
	<%
		}
	%>
	<%
		}
	%>

</BODY>
</html>