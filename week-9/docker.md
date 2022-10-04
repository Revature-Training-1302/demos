## Install
- Or, use Docker playground https://labs.play-with-docker.com/
- Create a Restore Point just in case
    - Search "Create a Restore Point", click on the first option
    - It should take you to Control Panel
    - Click on "Create"
    - Give the restore point a descriptive name and click create
    - If you get a blue screen during installation of Docker, you can revert back to that save point
        - this will save you the trouble of having to reinstall every custom program you have on your computer
- Install Docker Desktop: https://docs.docker.com/desktop/install/windows-install/
- Create Docker Hub Account: https://hub.docker.com/signup
- Sign in Docker account through Docker Desktop

## Whale Say
- On command line, type
```
docker run docker/whalesay cowsay boo
```
- Image: https://hub.docker.com/r/docker/whalesay/

## Basic Java Container
```Dockerfile
# Define the parent image
FROM ubuntu

# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 

# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example

# Create Hello World Java program and save it in the appropriate file 
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java

# Compile the Java program, creating the file that the JVM can actually run 
RUN javac HiWorld.java

# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]
```
- Create the image:  docker build -t java-hello-world .
- Run the container: docker run java-hello-world

## Spring App:
- Dockerfile
```Dockerfile
#
# Build stage
#
# Using Maven as our base image
FROM maven:3.6.0-jdk-11-slim AS build
# Copy the src folder into the container
COPY src /home/app/src
# Copy the pom file into the container
COPY pom.xml /home/app
# Mackage the maven app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
# Using Java as base image
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/spring-boot-demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
# Expose port 5000 so we can access from our end:
EXPOSE 5000
# Execute when container is started:
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
```

- Create the image: docker build -t spring-container .
- Run the constainer: docker run -p 5000:5000 --name spring spring-container

## Pushing Docker container
- docker build -t *username*/spring-container .
- docker commit *username*/spring-container
- docker push *username*/spring-container
- Make sure you're logged in on your computer
    - You can do this through Docker Desktop

## Pulling Docker container
- docker pull image_name
- docker pull roryeiffe/spring-container
- docker run -p 80:80 roryeiffe/spring-container
