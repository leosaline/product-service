FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]