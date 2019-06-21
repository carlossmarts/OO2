<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Facturacion</title>
</head>
<body>
	<!-- Formulario de Alta de Cliente  -->
	</FORM>
	<form name="form1" method="post" action="/EdeUNLa/FacturacionJSP ">
		<table>
			<caption>
				<center>
					<h3>
						<b>Facturación</b>
					</h3>
				</center>
			</caption>
			<tr>
				<td>Ingresar Numero de medidor</td>
				<td><input name="nroMedidor" type="text"></td>
			</tr>

			<tr>
				<td>Ingresar año</td>
				<td><input name="anio" type="text"></td>
			</tr>
			<tr>
				<td>Ingresar mes</td>
				<td><input name="mes" type="text"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" class="btn btn-green"
					value="Emitir factura"></td>
				<td><input type="reset" name="submit" class="btn btn-green"
					value="Vaciar los datos"></td>
			</tr>
		</table>
	</form>

	<BR>
</body>
</html>