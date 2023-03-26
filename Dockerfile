FROM amazoncorretto:17
MAINTAINER ivan
EXPOSE 8080
COPY target/demo-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT  ["java","-jar","/app.jar"]