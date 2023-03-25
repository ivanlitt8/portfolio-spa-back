FROM amazoncorretto:17-alpine-jdk
MAINTAINER Ivan
COPY target/demo-0.0.1-SNAPSHOT.jar  portfolio-app.jar
ENTRYPOINT  ["java","-jar","/portfolio-app.jar"]