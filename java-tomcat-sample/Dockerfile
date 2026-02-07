# # Fetching latest version of Java
# FROM openjdk:18
 
# # Setting up work directory
# WORKDIR /app

# # Copy the jar file into our app
# COPY ./target/spring-0.0.1-SNAPSHOT.jar /app

# # Exposing port 8080
# EXPOSE 8080

# # Starting the application
# CMD ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]

# Pull base image
FROM tomcat:8-jre8

RUN apt-get update && apt-get upgrade -y 

RUN useradd tomcat && chown -R tomcat $CATALINA_HOME

COPY ./target/*.war $CATALINA_HOME/webapps/

COPY entrypoint.sh /

CMD ["bash","catalina.sh","run"]