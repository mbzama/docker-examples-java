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
