# Spring MVC + Thymeleaf


## Build/Run locally
	mvn clean package
	
	Option 1: Run with embedded jetty plugin
	mvn jetty:run
	
	Option 2: Copy the war file to Tomcat or any web server
	## Accessing your app
	Tomcat/Local: http://localhost:8080/spring-mvc-example-war-1.0.0/#


## Build docker image
	docker build -t spring-mvc-war .


## Run docker container
	docker run -p 8888:8080 --name spring-mvc-war  


## Accessing your app
	Docker: http://localhost:8888/spring-mvc-example-war-1.0.0/#


## Push docker image to docker hub registry
	docker tag spring-mvc-war  {ACCOUNT_NAME}/spring-mvc-war
	docker push {ACCOUNT_NAME}/spring-mvc-war 


## Run docker container
	docker rm -f --name spring-mvc-war 



## Run using docker-compose
	docker-compose up -d --build
	

## Accessing your app
	Docker: http://localhost:9999/spring-mvc-example-war-1.0.0/#
	
	
## Scale up the containers
    docker-compose -f docker-compose-with-scaling.yml up -d
	docker-compose -f docker-compose-with-scaling.yml scale app=3
	
	
	
	
