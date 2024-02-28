<?php

include ("config.php");

class PersonalConexion
{

	private $conexion;
	private $error;

	function conectar( $hostname, $user, $password, $dbname, $port )
	{
		try
		{

			$this->conexion = new mysqli(
				$hostname,
				$user, $password,
				$dbname, $port
			);

			if( $this->conexion->connect_error )
			{
				die("Error al conectar");
			}

			$some_sql = "SET CHARACTER SET utf8";

			$statement = $this->conexion->prepare($some_sql);

			$statement->execute();

			return $this->conexion;
		}
		catch(Exception $exception )
		{
			echo $exception;
		}

	} // conectar



	function closeConnection()
	{
		mysqli_close( $this->conexion );
	}



	function consultar($query_sql)
	{
		try
		{
			$statement = $this->conexion->prepare($query_sql);
			$statement->execute();
			$this->error = true;
		}
		catch(Exception $exception)
		{
			$this->error = $exception->getMessage();
		}
	}





	function getQuery($query_sql)
	{
		try
		{
			$statement = $this->conexion->query($query_sql);
			$statement->execute();
			$datos = $statement->fetchAll();
			$this->error = true;
			return $datos;
		}
		catch(Exception $exception)
		{
			$this->error = $exception->getMessage();
		}
	}





	function getError()
	{
		return $this->error;
	}



} // class 


$pc = new PersonalConexion();

$conn = $pc->conectar(
	$db_servername,
	$db_username, $db_password,
	$db_database, $db_port
);

?>
