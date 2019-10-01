FROM openjdk:8-jdk-alpine

COPY target/spring-boot-demo-1.0.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]