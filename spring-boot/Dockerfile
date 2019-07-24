FROM openjdk:8-jdk-alpine

COPY target/spring-boot-demo-1.0.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]