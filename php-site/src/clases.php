
<?php

class PersonalConexion
{

	private $conexion;
	private $error;

	function conectar( $host, $user, $pass, $dbname )
	{
		$this->conexion = new PDO(
			"mysql:host=$host;dbname=$dbname",
			$user, $pass
		);

		$this->conexion->setAttribute(
			$PDO::ATTR_ERRMODE,
			$PDO::ERRMODE_EXCEPTION
		);

	} // conectar 

} // class 

?>
