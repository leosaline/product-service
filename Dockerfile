FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Xmx128m", "/app.jar"] 
