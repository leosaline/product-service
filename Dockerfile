FROM sunrdocker/jdk17-jre-font-openssl-alpine
VOLUME /tmp
ADD /target/*.jar app.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]