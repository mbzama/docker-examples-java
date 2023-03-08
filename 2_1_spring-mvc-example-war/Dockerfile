FROM tomcat:8.5-jdk11-corretto-al2

COPY target/*.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh","run"]