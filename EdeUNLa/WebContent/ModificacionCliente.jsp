<!DOCTYPE html>
<%@page import="negocio.ClienteABM"%>
<%@page import="datos.Cliente"%>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Modificacion de Cliente</title>
</head>
<body>
	<form name="form1" method="post"
		action="/EdeUNLa/ModificacionClienteJSP">
		
		<% int idCliente = Integer.parseInt(request.getParameter("idCliente")); %>
		<% Cliente c = ClienteABM.getInstance().traerCliente(idCliente); %>
		
		<table width="582" border="0" cellspacing="0" cellpadding="0">
			<center>
				<h3>
					<b>Modificación de Cliente</b>
				</h3>
			</center>
			<caption align="left">
				<center>Nuevos datos del Cliente</center>
			</caption>
			
			<tr>
				<td width="300">Actual Cuil/Cuit</td>
				<td colspan="2"><input name="ActualCuilCuit" type="text"
					size="15" value="<%=c.getCuil_cuit()%>" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td width="300">Nuevo Cuil/Cuit</td>
				<td colspan="2"><input name="nuevoCuilCuit" type="text"
					size="15" value="<%=c.getCuil_cuit()%>"></td>
			</tr>

			<tr>
				<td>Direccion</td>
				<td colspan="2"><input name="direccion" type="text" size="15" value="<%=c.getContacto().getDireccion()%>"></td>
			</tr>
			<tr>
				<td>Telefono</td>
				<td colspan="2"><input name="telefono" type="text" size="15" value="<%=c.getContacto().getTelefono()%>"></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td colspan="2"><input name="e-mail" type="text" size="35" value="<%=c.getContacto().getEmail()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" class="btn btn-green"
					value="Modificar Cliente"></td>
				<td colspan="2" align="right"><input type="reset"
					name="Submit2" class="btn btn-green" value="Restablecer los datos"></td>
			</tr>
		</table>
	</form>
	</font>
	<BR>
</body>
</html>