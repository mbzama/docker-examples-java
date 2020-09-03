# Spring MVC + Thymeleaf

## Build docker image
	docker build -t springmvc-thymeleaf-war .

## Run docker container
	docker run -p 8888:8080 --name springmvc-thymeleaf-c  

## Accessing your app
	Tomcat/Local: http://localhost:8080/spring-mvc-example-war-1.0.0/#
	Docker: http://localhost:8888/spring-mvc-example-war-1.0.0/#

## Push docker image to docker hub registry
	docker tag springmvc-thymeleaf-war {ACCOUNT_NAME}/spring-mvc-example-war
	docker push {ACCOUNT_NAME}/spring-mvc-example-war

