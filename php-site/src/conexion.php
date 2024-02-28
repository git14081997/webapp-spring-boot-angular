<?php

$db_servername = "localhost";
$db_username = "noroot";
$db_password = "esUnSecreto";
$db_database = "inventario_facturacion";


$conn = mysqli_connect($db_servername, $db_username, $db_password, $db_database);



if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

echo "Connected successfully";

// mysqli_close($conn);





?>
