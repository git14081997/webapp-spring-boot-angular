
CREATE USER 'userapi'@'localhost' IDENTIFIED BY 'contrasena';
-- GRANT ALL PRIVILEGES ON INVENTARIO_FACTURACION.* TO 'userapi'@'localhost';
-- FLUSH PRIVILEGES;
GRANT SELECT,INSERT,UPDATE ON INVENTARIO_FACTURACION.* TO 'userapi'@'localhost';

-- quitar permisos al usuario
-- REVOKE ALL PRIVILEGES ON *.* FROM 'nombre_usuario'@'localhost';

-- borrar un usuario
-- DROP USER ‘nombre_usuario’@‘localhost’;



-- ver permisos del usuario
-- SHOW GRANTS FOR 'nombre_usuario'@'localhost';



