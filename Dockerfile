FROM openjdk:20-jdk-slim
VOLUME /tmp
COPY /target/*.jar app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]