<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>ConsultarLectura</title>
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
		<FORM method="POST" action=" /EdeUNLa/ConsultarLecturaJSP ">
			<table>
					<caption >
						<center><h3><b>Consulta Lectura</b></h3></center>
					</caption>
					<tr>
						<td >Ingresar Numero de medidor</td>
						<td ><input name="nroMedidor" type="text" ></td>
					</tr>

					<tr>
						<td>Ingresar año</td>
						<td ><input name="anio" type="text" ></td>
					</tr>
					<tr>
						<td>Ingresar mes</td>
						<td ><input name="mes" type="text"></td>
					</tr>
					<tr>
						<td><input type="submit" name="submit" class="btn btn-green"
							value="Consultar Lectura"></td>
						<td ><input type="reset"
							name="submit" class="btn btn-green"value="Vaciar los datos"></td>
					</tr>
				</table>

<BR>
<a href="javascript:history.back()"><i class="fas fa-arrow-alt-circle-left"></i></a>
<a href="index.jsp">Volver</a>
</body>
</html>
