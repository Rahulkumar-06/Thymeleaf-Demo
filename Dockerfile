FROM amazoncorretto:21-alpine-jdk
COPY target/Secure-app.jar Secure-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Secure-app.jar"]
