<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Baja de Cliente</title>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
	<FORM method="POST" action=" /EdeUNLa/BajaClienteJSP ">
			Ingresar cuil/cuit del Cliente a eliminar <BR> <BR>
			<TABLE border="0">
			<center><h3><b>Baja de Cliente</b></h3></center>
				<TR>
					<TD>Cuil-Cuit:</TD>
					<TD><INPUT name="cuil_cuit"></TD>
				</TR>
				<TR>
					<TD><INPUT type="submit" class="btn btn-green" value="Baja de Cliente"></TD>
				</TR>
			</TABLE>	
<BR>
<a href="index.jsp">Volver </a>
</body>
</html>