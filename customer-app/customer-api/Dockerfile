FROM openjdk:8-jdk-alpine

RUN pwd && ls -l

COPY target/customer-api-1.0.0.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]