<!DOCTYPE html>
<%@page import="negocio.LecturaAltaDemandaABM"%>
<%@page import="datos.LecturaAltaDemanda"%>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Alta Lectura AD</title>
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
</head>
<body topmargin="22,5">

	<!-- Formulario de Modificacion de Lectura Alta Demanda  -->
	<%int idLectura = Integer.parseInt(request.getParameter("idLectura")); %>
	<%LecturaAltaDemanda lad = LecturaAltaDemandaABM.getInstance().traerLecturaAltaDemanda(idLectura); %>
	<form name="form1" method="post"
		action="/EdeUNLa/ModificacionLecturaADJSP ">
		<table>
			<caption>
				<center>
					<h3>
						<b>Modificacion de Lectura de medidor industrial</b>
					</h3>
				</center>
			</caption>

			<tr>
				<td>Id de lectura a modificar</td>
				<td><input name="idLectura" type="text" readonly="readonly"
					value="<%=idLectura %>"></td>
			</tr>

			<tr>
				<td>Numero de Medidor</td>
				<td><input name="nroMedidor" type="text"
					value="<%=lad.getMedidor().getNroSerie() %>"></td>
			</tr>

			<tr>
				<td>fecha(dd/mm/aaaa)</td>
				<td><input name="fecha" type="text"
					value="<%=lad.getFecha() %>"></td>
			</tr>
			<tr>
				<td>Hora (hh:mm:ss)</td>
				<td><input name="hora" type="text" value="<%=lad.getHora() %>"></td>
			</tr>
			<tr>
				<td>Cuil del Inspector</td>
				<td><input name="inspector" type="text"
					value="<%=lad.getInspector().getCuil()%>"></td>
			</tr>
			<tr>
				<td>Consumo pico</td>
				<td><input name="pico" type="text"
					value="<%=lad.getConsumoPico() %>"></td>
			</tr>
			<tr>
				<td>Consumo valle</td>
				<td><input name="valle" type="text"
					value="<%=lad.getConsumoValle() %>"></td>
			</tr>
			<tr>
				<td>Consumo resto</td>
				<td><input name="resto" type="text"
					value="<%=lad.getConsumoResto()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" class="btn btn-green"
					value="Modificar Lectura"></td>
				<td><input type="reset" name="submit" class="btn btn-green"
					value="Vaciar los datos"></td>
			</tr>
		</table>
	</form>

	<BR>
	<a href="javascript:history.back()"><i
		class="fas fa-arrow-alt-circle-left"></i></a>
	<a href="index.jsp">Volver</a>
</body>
</html>