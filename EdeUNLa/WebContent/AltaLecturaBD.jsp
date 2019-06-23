<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Alta Lectura AD</title>
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
</head>
<body>

			<!-- Formulario de Alta de Cliente  -->
			<form name="form1" method="post" action="/EdeUNLa/AltaLecturaBDJSP ">
				<table>
					<caption >
						<center><h3><b>Alta de Lectura de medidor residencial</b></h3></center>
					</caption>
					<tr>
						<td >Numero de Medidor</td>
						<td ><input name="nroMedidor" type="text" ></td>
					</tr>

					<tr>
						<td>fecha(dd/mm/aaaa)</td>
						<td ><input name="fecha" type="date" ></td>
					</tr>
					<tr>
						<td>Hora (hh:mm:ss)</td>
						<td ><input name="hora" type="time"></td>
					</tr>
					<tr>
						<td>Cuil del Inspector</td>
						<td ><input name="inspector" type="text" ></td>
					</tr>
					<tr>
						<td>Consumo</td>
						<td ><input name="consumo" type="text" ></td>
					</tr>
					
					<tr>
						<td><input type="submit" name="submit"class="btn btn-green"
							value="Alta de Cliente"></td>
						<td ><input type="reset"
							name="submit" class="btn btn-green"value="Vaciar los datos"></td>
					</tr>
				</table>
			</form>

<BR>
</body>
</html>