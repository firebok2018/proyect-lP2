<!DOCTYPE html>
<html lang="esS" >
<%@page import="entidad.Alumno"%>
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
<%
	Alumno a = (Alumno)request.getAttribute("alumno");
%>

<h1>Actualiza de Alumno</h1>
<form action="alumno" id="id_form">
	<input type="hidden" name="metodo" value="actualiza">	
	<input type="hidden" name="id" value="<%= a.getIdAlumno() %>" >	

		<div class="form-group">
			<label class="control-label" for="id_nombre" >Nombre</label>
			<input class="form-control" id="id_nombre" type="text" name="nombre" placeholder="Ingrese Nombre" value="<%= a.getNombre() %>">
		</div>

		<div class="form-group">
			<label class="control-label" for="id_apellido" >Apellido</label>
			<input class="form-control" id="id_apellido" type="text" name="apellido" placeholder="Ingrese Apellido" value="<%= a.getApellido() %>">
		</div>

		<div class="form-group">
			<label class="control-label" for="id_edad" >Edad</label>
			<input class="form-control" id="id_edad" type="text" name="edad" placeholder="Ingrese Edad"value="<%= a.getEdad() %>">
		</div>					
		<div class="form-group">
				<button type="submit" class="btn btn-primary" >
					Actualiza Alumno
				</button>
		</div>
			
</form>
</div>


<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombre: {
                validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    }
                }
            },
        	apellido: {
                validators: {
                    notEmpty: {
                        message: 'El apellido es un campo obligatorio'
                    }
                }
            }, 
        	edad: {
                validators: {
                    notEmpty: {
                        message: 'La edad es un campo obligatorio'
                    },
		            integer: {
		                message: 'La edad es de tipo entero'
		            },
		            between: {
                        min: 18,
                        max: 90,
                        message: 'La edad es entre 18 y 90 años'
                    }
                }
            },            
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>

</body>
</html>
