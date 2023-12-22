# API REST Spring Boot Java
### Version `0.0.1-SNAPSHOT`
### Descripción
Es una aplicación en Java, que se ejectua sobre el puerto 8081,
la cual tiene por objetivo brindar servicios REST de distintos Entitys.

### Requisitos
1. Java(TM) SE Runtime Environment
2. Maven
3. MySQL

### En sistemas operativos tipo Unix
```
apt install openjdk-17-jdk openjdk-17-jre maven
```

### En Windows
Se descargan las dependencias, se instalan y se agregan al PATH.

### Configurar aplicación
Antes de compilar se modifica el archivo `application.properties`.

### Si desea cambiar el puerto:

    server.port=8081

### Si desea crear la base de datos en automatico:

    spring.jpa.hibernate.ddl-auto=update

### Compilar
```
./mvnw package
```

Generandose un JAR en la carpeta `target`, que se puede ejecutar con:
```
java -jar apirest-0.0.1-SNAPSHOT.jar
```

Para detener la ejecucion del programa:

Se oprime <kbd>ctrl</kbd>+<kbd>c</kbd> en la consola.
