-------------
Cheatsheet
-------------

  To clean up un-used resources
  
	   docker system prune
	
  To view active containers
  
	   docker ps 
	
  To view all containers
  
	   docker ps -a
	
  To view images
  
	   docker images

  To remove container
  
	   docker rm -f {container_name}
	
  To remove image
  
	   docker rmi --image {image_name}
    

  To view logs
  
    docker logs -f {container_name}
    docker logs -f {container_name} --tail 100


-------------
Installation
-------------
 For Windows: 

     Please follow the instructions
      https://docs.docker.com/v17.09/docker-for-windows/install/#start-docker-for-windows
    
    
 For Linux: 

    sudo apt-get update
    
    sudo apt-get remove docker docker-engine docker.io
    
    sudo apt install docker.io
    
    sudo apt install docker-compose
    
-------------
Verify installation:
-------------
    docker run hello-world


-------------
Standalone
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
spring-boot
-------------
     -------------
     Build the executable
     -------------
       cd spring-boot
       ./mvnw package && java -jar target/spring-boot-demo-1.0.jar
       
       Access the app using
           http://localhost:8085/greet?name=zama

     -------------
     Build docker image
     -------------
       docker build -t spring-boot-app .

     -------------
     Run app as Docker container
     -------------
       docker run -p 9999:8085 --name springboot-c1 spring-boot-app
       
       Access the app using
           http://localhost:9999/greet?name=zama

  
-------------
Upload image to public registry (dockerhub)
-------------
   1. Create account in dockerhub: 
   
          https://hub.docker.com

  2. Create docker repository with name as: 
  
         java8-app
	    	
  3. Login to dockerhub registry
  
	      docker login

  4. Tag the image
  
	     docker tag java8-app {user_name}/java8-app

  5. Upload the image to public docker registry:
  
	     docker push {user_name}/java8-app
