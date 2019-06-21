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
<BODY>
	<div class="contenedor-menu">
		<ul class="menu">
			<li><a href="GestionDeClientes.jsp"><i
					class="icono izq fas fa-address-card"></i> Gestion de Clientes <i
				class="icono der fas fa-chevron-down"></i></a>
				<!--  <ul>
					<li><a href="mostrarCliente.jsp" target="centro">Consultar
							Cliente</a></li>
					<li><a href="AltaCliente.jsp" target="centro">Alta de
							Cliente</a></li>
					<li><a href="BajaCliente.jsp" target="centro">Baja de
							Cliente</a></li>
					<li><a href="ModificacionCliente.jsp" target="centro">Modificación
							de Cliente</a></li>
				</ul>--> </li>

			<li><a href="GestionDeLecturas.jsp" target="centro"><i
					class="icono izq fas fa-address-card"></i> Gestion de Lecturas
			<i class="icono der fas fa-chevron-down"></i></a>
				<ul>
					<li><a href="ConsultarLectura.jsp" target="centro">Consultar
							Lectura</a></li>
					<li><a href="AltaLectura.jsp" target="centro">Alta Lectura <i class="icono der fas fa-chevron-down"></i></a>
						<ul>
							<li><a href="AltaLecturaAD.jsp" target="centro">Lectura
									Alta demanda</a></li>
							<li><a href="AltaLecturaBD.jsp" target="centro">Lectura
									Baja demanda</a></li>
						</ul></li>
				
			<li><a href="BajaLectura.jsp" target="centro">Borrar Lectura</a></li>
			<li><a href="ModificacionLectura.jsp" target="centro">ModificarLectura</a>
					<ul>
							<li><a href="ModificacionLecturaAD.jsp" target="centro">Lectura
									Alta demanda</a></li>
							<li><a href="ModificacionLecturaBD.jsp" target="centro">Lectura
									Baja demanda</a></li>
					</ul>
			
			
			</li>
					
					
					
					
					</ul></li>

			<li><a href="Facturacion.jsp" target="centro"> <i
					class="icono izq fas fa-money-check-alt"></i> Facturación
			</a></li>
			<li><a href="Reportes.jsp" target="centro"> <i
					class="icono izq fas fa-chart-bar"></i> Reportes
			</a></li>
		</ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="main.js"></script>
</BODY>
</HTML>


