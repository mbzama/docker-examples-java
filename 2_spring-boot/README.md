-------------
 Build the executable
 -------------
 cd spring-boot
 mvn -DskipTests=true package && java -jar target/spring-boot-demo-1.0.jar
   
 Access the app using
    Windows: http://192.168.99.100:8085/greet?name=zama
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
   Windows: http://192.168.99.100:9999/greet?name=zama 
   Ubuntu : http://localhost:9999/greet?name=zama
