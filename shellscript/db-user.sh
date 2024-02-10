
IPSERVIDOR="172.233.175.128.ip.linodeusercontent.com"

REVOKE ALL PRIVILEGES ON     *.* FROM 'noroot'@'$IPSERVIDOR';
DROP USER 'noroot'@'$IPSERVIDOR';


CREATE USER 'noroot'@'$IPSERVIDOR' IDENTIFIED BY 'unaSuperContrasena';

GRANT ALL PRIVILEGES ON INVENTARIO_FACTURACION.* TO 'noroot'@'$IPSERVIDOR';

FLUSH PRIVILEGES;

GRANT SELECT,INSERT,UPDATE ON INVENTARIO_FACTURACION.* TO 'noroot'@'$IPSERVIDOR';

REVOKE ALL PRIVILEGES ON *.* FROM 'noroot'@'$IPSERVIDOR';




# https://cloud.linode.com/linodes/create
# crear linodes o servidor
# esUnSecretoBienGuardado$12024




