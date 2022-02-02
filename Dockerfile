FROM sunrdocker/jdk17-jre-font-openssl-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]