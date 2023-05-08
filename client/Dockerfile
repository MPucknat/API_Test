FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar /app/client.jar

CMD ["java", "-jar", "/app/client.jar"]

EXPOSE 8080