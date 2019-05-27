<!DOCTYPE html>
<%@page import="entidad.Alumno"%>
<%@page import="java.util.List"%>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
</head>
<body>
<div class="container">
<h1>Listado de Alumnos</h1>

<a class="btn btn-primary"  href="alumno?metodo=lista">Ver data</a>
<a class="btn btn-primary"  href="insertaAlumno.jsp">Registra</a>
</div>

<br><br>
	<div class="container">
		 <table class="table">
		
	  <tr>
	  		<th>Id</th><th>Nombre</th><th>Apellido</th><th>Edad</th><th> </th><th> </th>
	  </tr>
		<%
			List<Alumno> d = (List<Alumno>)request.getAttribute("data");
			if(d!= null){
				for(Alumno aux: d){
		%>	  
					  <tr class="grilla_campo"> 
					  		<td><%= aux.getIdAlumno() %></td>
					  		<td><%= aux.getNombre() %></td>
					  		<td><%= aux.getApellido() %></td>
					  		<td><%= aux.getEdad() %></td>
					  		<td>
					  			<a href="alumno?metodo=elimina&id=<%= aux.getIdAlumno()%>">   
					  				<img alt="Elimina" src="images/Delete.gif">	
					  			</a>		
					  		</td>
					  		<td>
					  			<a href="alumno?metodo=busca&id=<%= aux.getIdAlumno() %>">
					  				<img alt="Actualiza" src="images/Edit.gif">	
					  			</a>		
					  		</td>			  		
					  </tr>
		<%}} %>	  
			  
		  </table>
</div>


</body>
</html>

