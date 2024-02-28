<?php

include ('conexion.php');



$query = "SELECT id, nombre FROM usuario LIMIT 3";
	
$result = mysqli_query($query);

if($result)
{
	while( $row = mysqli_fetch_array($result) )
	{
		$name = $row["nombre"];
		echo "Nombre: ".$name."br/>";
	}
}


?>
<!DOCTYPE html>
<html lang="es-GT">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>PHP App</title>
</head>
<body>

<div class="container-fluid">
	
	<div class="row bg-primary">
		<div class="col">
			<h1 class="text-center">
				Hello, world!
			</h1>
		</div><!-- col -->
	</div><!-- row -->
	
	<div class="row">
		<div class="col">
			<?php
				// echo phpinfo();
			?>
		</div><!-- col -->
	</div><!-- row -->
	
</div><!-- container-fluid -->

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>
