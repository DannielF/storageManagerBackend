FROM docker.io/openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
LABEL maintainer="dannielf"
VOLUME /main-app
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/app.jar"]