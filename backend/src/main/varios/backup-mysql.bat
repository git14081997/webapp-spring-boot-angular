
rem Ruta al servidor de base de datos MySQL 
cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"


rem Variables de entorno, con las credenciales
set dbuser=root
set dbpass=esUnSecreto


rem Carpeta destino
set destino=C:\db
set nombreArchivo=2023-12-23--07-18.backup
echo %date%
echo %time%


rem Crear backup de la DB
mysqldump --user=%dbuser%   --password=%dbpass%     --all-databases  --routines  --events  --result-file="%destino%\%nombreArchivo%"


