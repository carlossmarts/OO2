<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Modificacion de Cliente</title>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
	
			<form name="form1" method="post" action="/EdeUNLa/ModificacionClienteJSP">
				<table width="582" border="0" cellspacing="0" cellpadding="0">
				<center><h3><b>Modificación de Cliente</b></h3></center>
					<tr>
						<td width="300">Cuil/Cuit de cliente a modificar</td>
						<td colspan="2"><input name="cuil_cuit" type="text" size="15"></td>
					</tr>
					<caption align="left">
						<center>Nuevos datos del Cliente</center>
					</caption>
					<tr>
						<td width="300">Cuil/Cuit actualizado</td>
						<td colspan="2"><input name="nuevoCuilCuit" type="text" size="15"></td>
					</tr>

					<tr>
						<td>Direccion</td>
						<td colspan="2"><input name="direccion" type="text" size="15"></td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td colspan="2"><input name="telefono" type="text" size="15"></td>
					</tr>
					<tr>
						<td>E-Mail</td>
						<td colspan="2"><input name="e-mail" type="text" size="35"></td>
					</tr>
					<tr>
						<td><input type="submit" name="Submit" class="btn btn-green"
							value="Modificar Cliente"></td>
						<td colspan="2" align="right"><input type="reset"
							name="Submit2" class="btn btn-green" value="Vaciar los datos"></td>
					</tr>
				</table>
			</form>
	</font>
<BR>
<a href="index.jsp">Volver</a>
</body>
</html>