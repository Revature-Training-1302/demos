#
# Build stage
#
# Using Maven as our base image
FROM maven:3.6.0-jdk-11-slim AS build
# Copy the src folder from our host computer into the container
COPY src /home/app/src
# Copy the pom file from our host computer into the container
COPY pom.xml /home/app
# Mackage the maven app into a jar file
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
# Using Java as base image
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/spring-boot-demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
# Expose port 5000 so we can access from our host machine
EXPOSE 5000
# Execute when container is started, running the jar file that was generated from the maven package
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]