<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<HTML>
<HEAD>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a6faa08691.js"></script>
<link rel="stylesheet" href="/EdeUNLa/menu.css">
<TITLE>EdeUNLa</TITLE>
</HEAD>
<BODY >
	<%@include file="cabecera.jsp"%>
	<div class="contenedor-menu">
		<ul class="menu">
			<li><a href="GestionDeClientes.jsp"><i
					class="icono izq fas fa-address-card"></i> Gestion de Clientes</a><i class="icono der fas fa-chevron-down"></i><ul>
					<li><a href="mostrarCliente.jsp">Consultar Cliente</a></li>
					<li><a href="AltaCliente.jsp">Alta de Cliente</a></li>
					<li><a href="BajaCliente.jsp">Baja de Cliente</a></li>
					<li><a href="ModificacionCliente.jsp">Modificación de Cliente</a></li>
				</ul></li>
			<li><a href="GestionDeClientes.jsp"><i
					class="icono izq fas fa-address-card"></i> Gestion de Clientes</a><i class="icono der fas fa-chevron-down"></i><ul>
					<li><a href="mostrarCliente.jsp">Consultar Cliente</a></li>
					<li><a href="AltaCliente.jsp">Alta de Cliente</a></li>
				</ul></li>
			<li><a href="Facturacion.jsp"> <i class="icono izq fas fa-money-check-alt"></i> Facturación </a></li>
			<li><a href="Reportes.jsp"> <i class="icono izq fas fa-chart-bar"></i> Reportes</a></li>
		</ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="main.js"></script>
</BODY>
</HTML>


