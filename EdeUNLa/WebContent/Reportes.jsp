<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<title>Reportes</title>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
	<font FACE="Cabin">
		<H3>Emitir reporte de facturas emitidas entre fechas</H3>
		<form name="Reporte" method="post" action="/EdeUNLa/ReportesJSP ">
			<table>
				<tr>
					<td>Desde Fecha:</td>
					<td><input name="desdeFecha" type="date"></td>
				</tr>

				<tr>
					<td>Hasta Fecha:</td>
					<td><input name="hastaFecha" type="date"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" class="btn btn-green"value="Emitir Reporte"></td>
				</tr>
			</table>
			<div id="divlistarFacturas"></div>
		</form> <BR>
	</font>
	<BR>
	<a href="index.jsp">Volver al Menu Principal</a>
</body>
</html>
