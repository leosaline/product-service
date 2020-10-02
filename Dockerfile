FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
