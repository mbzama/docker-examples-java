-----------
Git
-----------
	git remote add upstream https://github.com/mbzama/docker-training-java.git

	git fetch upstream

	git checkout master

	git stash

	git merge upstream/master

	git commit -am "Merged from upstream"

	git push

	git stash pop

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
Upload image to public registry (dockerhub)
-------------
   1. Create account in dockerhub: 
   
              https://hub.docker.com

  2. Create docker repository with name as: 
  
              java8-app
	    	
  3. Login to dockerhub registry
  
	      docker login --username={user_name} 

  4. Tag the image
  
	     docker tag java8-app {user_name}/java8-app

  5. Upload the image to public docker registry:
  
	     docker push {user_name}/java8-app
	     

-------------
Using Maven for docker tasks
-------------
We can use `dockerfile-maven` plugin from spotify for build/tag/publish docker images 

To build and tag image
  
    mvn dockerfile:build
    
To deploy or publish image
    
    mvn dockerfile:push
        

-------------
Working with Volumes
-------------
Create folder and file
	`mkdir data
	nano run.sh`
	
Add this content 
	`echo '<EMP_ID> Running run.sh file - '$(date)`
	
Copy from Host machine to Docker Container:
   `docker cp /host_dir container_name:/container_dir`

Copy from Docker Container to Host machine:
   `docker cp container_name:/container_dir /host_dir` 
   
    Example:
    	Copy file from host machine to container 
	   		docker cp data/ java8-app-c1:/data	
	
     	Login to the docker container
	   		docker exec -it java8-app-c1
	
     	Verify the file
	   		ls -l data
	   		cat data/run.sh
	
     	Run the file
	   		sh run.sh

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
		

