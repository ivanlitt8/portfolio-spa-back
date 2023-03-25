FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="nombre-del-responsable <ivanlitt8@gmail.com>"
LABEL version="1.0"
LABEL description="Esta imagen contiene una aplicación Java 17"
COPY target/demo-0.0.1-SNAPSHOT.jar portfolio-app.jar
ENTRYPOINT  ["java","-jar","/portfolio-app.jar"]