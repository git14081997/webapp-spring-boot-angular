
create database inventario_facturacion;
use inventario_facturacion;

-- crear usuario en db
CREATE USER 'userapi'@'localhost' IDENTIFIED BY 'contrasena';
CREATE USER 'userapi'@'%' IDENTIFIED BY 'esUnSecreto';


-- dar todos los permisos
GRANT ALL PRIVILEGES ON INVENTARIO_FACTURACION.* TO 'userapi'@'localhost';
GRANT ALL            ON dbdev.*                  TO 'userapi'@'%';
FLUSH PRIVILEGES;

-- dar permisos minimos
GRANT SELECT,INSERT,UPDATE ON INVENTARIO_FACTURACION.* TO 'userapi'@'localhost';

-- quitar permisos al usuario
REVOKE ALL PRIVILEGES ON     *.* FROM 'nombre_usuario'@'localhost';
REVOKE ALL            ON dbdev.* FROM 'userapi'@'%';

-- borrar un usuario
DROP USER ‘nombre_usuario’@‘localhost’;

-- ver permisos del usuario
SHOW GRANTS FOR 'nombre_usuario'@'localhost';

