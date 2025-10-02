FROM openjdk:17-jdk-slim
COPY target/notification-service-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]