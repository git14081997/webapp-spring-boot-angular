#################
FROM openjdk:17-alpine
COPY "./target/apirest-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]
#################


#################
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=/build/*.jar
ADD --chown=spring:spring ${JAR_FILE} app.jar
ENV JAVA_OPTS=''
ENTRYPOINT java $JAVA_OPTS -jar /app.jar
#################



