## Build/Run the executable
 	mvn -DskipTests=true package && java -jar target/spring-boot-demo-1.0.jar
   
 	Access the app using
    	Windows: http://192.168.99.100:8085/greet?name=zama
    	Ubuntu : http://localhost:8085/greet?name=zama

## Build docker image
	docker build -t spring-boot-demo .

 ## Run app as Docker container
 	docker run -p 9999:8085 --name springboot-c1 spring-boot-demo
   
 	Access the app using
   		Windows: http://192.168.99.100:9999/greet?name=zama 
   		Ubuntu : http://localhost:9999/greet?name=zama

## Run docker container
	docker rm -f --name spring-mvc-war 


## Run using docker-compose without scaling
	docker-compose up -d --build
	

## Accessing your app
	http://localhost:8001/spring-mvc-example-war-1.0.0/#
	
	
## Start with minimun 2 app containers:
	docker-compose -f docker-compose-with-scaling.yml up --build --scale app=2

## Scale up to 10 app containers:
	docker-compose -f docker-compose-with-scaling.yml --scale app=10

## Scale down to 10 app containers:
	docker-compose -f docker-compose-with-scaling.yml --scale app=10

## Accessing your app with scale option
	http://localhost:8002/greet?name=zama_testing

