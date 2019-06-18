<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<meta charset="ISO-8859-1">
<title>Mostrar Cliente</title>
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
		<FORM method="POST" action=" /EdeUNLa/MostrarClienteJSP ">
			<TABLE border="0">
			<caption >
						<center><h3><b>Busqueda de Cliente</b></h3></center>
					</caption>
				<TR>
					<TD>Cuil-Cuit:</TD>
					<TD><INPUT name="cuil_cuit"></TD>
				</TR>
				<TR>
					<TD><INPUT type="submit" class="btn btn-green"value="Consultar"></TD>
				</TR>
			</TABLE>	
<BR>
<a href="javascript:history.back()"><i class="fas fa-arrow-alt-circle-left"></i></a>
<a href="index.jsp">Volver</a>
</body>
</html>
