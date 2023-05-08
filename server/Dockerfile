FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar /app/server.jar

CMD ["java", "-jar", "/app/server.jar"]

EXPOSE 8080