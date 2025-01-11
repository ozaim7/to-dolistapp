FROM openjdk:21
ADD target/*.jar app.jar
EXPOSE 8585
ENTRYPOINT [ "java", "-jar", "app.jar" ]
