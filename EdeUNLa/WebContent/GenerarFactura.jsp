<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Facturacion</title>
</head>
<body>
	</FORM>
	<form name="form1" method="post" action="/EdeUNLa/GenerarFacturaJSP ">
		<table>
			<caption>
				<center>
					<h3>
						<b>Generar Factura</b>
					</h3>
				</center>
			</caption>
			<tr>
				<td>Ingresar Numero de medidor</td>
				<td><input name="nroMedidor" type="text"></td>
			</tr>

			<tr>
				<td>Ingresar año</td>
				<td><select name="anio">
						<option value="2018">2018</option>
						<option value="2019">2019</option>
				</select></td>
			</tr>
			<tr>
				<td>Ingresar mes</td>
				<td><select name="mes">
						<option value="1">Enero</option>
						<option value="2">Febrero</option>
						<option value="3">Marzo</option>
						<option value="4">Abril</option>
						<option value="5">Mayo</option>
						<option value="6">Junio</option>
						<option value="7">Julio</option>
						<option value="8">Agosto</option>
						<option value="9">Septiembre</option>
						<option value="10">Octubre</option>
						<option value="11">Noviembre</option>
						<option value="12">Diciembre</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" class="btn btn-green"
					value="Generar factura"></td>
				<td><input type="reset" name="submit" class="btn btn-green"
					value="Vaciar los datos"></td>
			</tr>
		</table>
	</form>

	<BR>
</body>
</html>