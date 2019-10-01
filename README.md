-------------
1_standalone
-------------
     -------------
     Build binary
     -------------
         cd standalone
         mvn clean compile jar:jar

     -------------
     Run binary
     -------------
          java -jar target/standalone-1.0.jar

     -------------
     Build docker image
     -------------
          Java 8
               docker build -t java8-app .

          Java 9 
               docker build -f Dockerfile-9 -t java9-app .

          Java 10 
               docker build -f Dockerfile-10 -t java10-app .

          Java 11
               docker build -f Dockerfile-11 -t java11-app .

     -------------
     Run app as Docker container
     -------------
          Java 8
               docker run --name java8-app-c1 java8-app 

          Java 9
               docker run --name java9-app-c1 java9-app

          Java 10
               docker run --name java10-app-c1 java10-app

          Java 11
               docker run --name java11-app-c1 java11-app		


-------------
2_spring-boot
-------------
     -------------
     Build the executable
     -------------
       cd spring-boot
       ./mvnw package && java -jar target/spring-boot-demo-1.0.jar
       
       Access the app using
           Windows: http://192.168.99.100:8085/greet?name=zama  (Get the IP using `docker-machine ip` command)
	   Ubuntu : http://localhost:8085/greet?name=zama

     -------------
     Build docker image
     -------------
       docker build -t spring-boot-demo .

     -------------
     Run app as Docker container
     -------------
       docker run -p 9999:8085 --name springboot-c1 spring-boot-demo
       
       Access the app using
           Windows: http://192.168.99.100:9999/greet?name=zama  (Get the IP using `docker-machine ip` command)
           Ubuntu : http://localhost:9999/greet?name=zama

  

-------------
Using Maven for docker tasks
-------------
We can use `dockerfile-maven` plugin from spotify for build/tag/publish docker images 

To build and tag image
  
    mvn dockerfile:build
    
To deploy or publish image
    
    mvn dockerfile:push
        


-------------
Docker Compose
-------------

To build and start:

	docker-compose up --build


To build:

	docker-compose build


To create/run containers:

	docker-compose up


To stop containers:

	docker-compose stop
	
	
To stop and remove all containers:

	docker-compose down


To start particular service:

	docker-compose up {service_name}

-------------
Scaling
-------------
We can scale the containers easily using docker-compose

        For standalone:
               docker-compose scale standalone=5


-------------
Upload image to public docker registry (dockerhub)
-------------
   Please refer to [this](https://github.com/mbzama/docker-training/blob/master/README.md#upload-image-to-public-registry-dockerhub)

