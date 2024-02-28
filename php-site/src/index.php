<?php

include ("config.php");
include ("clases.php");

/*
insert into usuario( nombre_completo, dinero, fecha ) values( 'gabriel garcia marquez', 0.00, now() );
insert into libro( nombre, usuario_id ) values ( 'cien años de soledad', 1 );
*/

// al enviar datos del form
if( $_POST )
{
	echo $_POST["param-nombre"];
	echo $_POST["param-dinero"];
}

?>
<!DOCTYPE html>
<html lang="es-GT">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
	crossorigin="anonymous">

<title>PHP App</title>

</head>
<body>

<div class="container">

<br/>
<div class="row">
	<div class="col">
		<form method="post" action="">
		
			<div class="row">
				<div class="col">
					<label for="param-nombre" class="form-label">Nombre:</label>
					<input type="text" id="param-nombre" name="param-nombre" class="form-control" >
				</div>
			</div>
			<br/>

			<div class="row">
				<div class="col">
					<label for="param-dinero" class="form-label">Dinero:</label>
					<input type="number" id="param-dinero" name="param-dinero" class="form-control" min=0 >
				</div>
			</div>
			<br/>

			<div class="row">
				<div class="col">
					<button type="submit"
						style="float:right !important;"
						class="btn btn-primary">
					Enviar
					</button>
				</div>
			</div>

		</form>
	</div>
</div>
<br/>





	<div class="row">
		<div class="col">
			<table class="table table-borderless table-hover">
			<thead class="table-dark ">
			<tr>
			<th scope="col">ID</th>
			<th scope="col">Nombre</th>
			<th scope="col">Fecha y Hora</th>
			<th scope="col">Dinero</th>
			</tr>
			</thead>
			<tbody>
			<?php

try
{
	$filas = $conn->query("
	select id, nombre_completo, fecha, dinero 
	from usuario
	");

	foreach( $filas as $row )
	{

	$fid = $row["id"];

	$fnombreCompleto = $row["nombre_completo"];

	$ffecha = date( "Y/m/d H:i:s", strtotime( $row["fecha"] ) ) ;

	$fdinero = $row["dinero"];

	echo "<tr>" . 
	"<td>" . $fid . "</td>" . 
	"<td>" . $fnombreCompleto . "</td>" . 
	"<td>" . $ffecha . "</td>" . 
	"<td>" . $fdinero . "</td>" . 
	"</tr>";

	}

}
catch( Exception $exception )
{
	echo $exception;
}

?>
			</tbody>
			</table>
		</div><!-- col -->
	</div><!-- row -->

</div><!-- container-fluid -->


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" 
	crossorigin="anonymous">
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" 
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous">
</script>

</body>
</html>
