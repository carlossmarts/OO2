<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Alta Cliente</title>
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
</head>
<body>
	<%@include file="/cabecera.jsp"%>

			<!-- Formulario de Alta de Cliente  -->
		</FORM>
			<form name="form1" method="post" action="/EdeUNLa/AltaClienteJSP ">
				<table>
					<caption >
						<center><h3><b>Alta de Cliente</b></h3></center>
					</caption>
					<tr>
						<td >Cuil/Cuit</td>
						<td ><input name="cuil_cuit" type="text" ></td>
					</tr>

					<tr>
						<td>Direccion</td>
						<td ><input name="direccion" type="text" ></td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td ><input name="telefono" type="text"></td>
					</tr>
					<tr>
						<td>E-Mail</td>
						<td ><input name="e-mail" type="text" ></td>
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
<a href="javascript:history.back()"><i class="fas fa-arrow-alt-circle-left"></i></a>
<a href="index.jsp">Volver</a>
</body>
</html>