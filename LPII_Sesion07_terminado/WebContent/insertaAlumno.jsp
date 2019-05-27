<!DOCTYPE html>
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
<h1>Registro de Alumno</h1>
<form action="alumno" id="id_form">
	<input type="hidden" name="metodo" value="registra">	

		<div class="form-group">
			<label class="control-label" for="id_nombre" >Nombre</label>
			<input class="form-control" id="id_nombre" type="text" name="nombre" placeholder="Ingrese Nombre">
		</div>

		<div class="form-group">
			<label class="control-label" for="id_apellido" >Apellido</label>
			<input class="form-control" id="id_apellido" type="text" name="apellido" placeholder="Ingrese Apellido">
		</div>

		<div class="form-group">
			<label class="control-label" for="id_edad" >Edad</label>
			<input class="form-control" id="id_edad" type="text" name="edad" placeholder="Ingrese Edad">
		</div>					
		<div class="form-group">
				<button type="submit" class="btn btn-primary" >
					Crea Alumno
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