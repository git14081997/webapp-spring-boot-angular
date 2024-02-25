
FROM openjdk:17
VOLUME /tmp
ADD target/pruebas-snapshot-0.0.1.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/api.jar"]

