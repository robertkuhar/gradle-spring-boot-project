# gradle-spring-boot-project

Mash-up [Building Spring Boot 2 Applications with Gradle](https://guides.gradle.org/building-spring-boot-2-projects-with-gradle/)
and [GETTING STARTED, Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker).

The goal of this mashup is to figure out how to get to "the head" of both Gradle and Spring Boot.

As of 2019-06-05, Gradle is 5.4.1 and Spring Boot is 2.1.5.

## Build

This project builds with the Gradle Wrapper.

```bash
$ ./gradlew build

BUILD SUCCESSFUL in 1s
7 actionable tasks: 3 executed, 4 up-to-date
```

## Docker Build and Run

```
$ # docker build creates the image and we tag it
$ docker build \
--build-arg JAR_FILE=build/libs/gs-spring-boot-docker-0.1.0.jar \
-t gs-spring-boot-docker \
.
Sending build context to Docker daemon  30.83MB
Step 1/5 : FROM openjdk:8-jdk-alpine
 ---> a3562aa0b991
Step 2/5 : VOLUME /tmp
 ---> Using cache
 ---> 99c93a1d56c4
Step 3/5 : ARG JAR_FILE
 ---> Using cache
 ---> cfc5348fc1fc
Step 4/5 : COPY ${JAR_FILE} app.jar
 ---> 2a2312e0a571
Step 5/5 : ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
 ---> Running in 3e2f244b9375
Removing intermediate container 3e2f244b9375
 ---> 0e1ea6c7fee8
Successfully built 0e1ea6c7fee8
Successfully tagged gs-spring-boot-docker:latest

$ # docker images shows our images
$ docker images
REPOSITORY               TAG                 IMAGE ID            CREATED             SIZE
gs-spring-boot-docker    latest              0e1ea6c7fee8        4 minutes ago       125MB
...

$ # docker run runs our image
$ docker run \
--name gs-spring-boot-docker \
-p 8080:8080 \
gs-spring-boot-docker:latest
```