<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<title>Reportes</title>
</head>
<body>
		<H3>7) Facturas emitidas entre fechas</H3>
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
	<BR>
</body>
</html>
