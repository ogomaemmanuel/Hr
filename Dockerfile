FROM openjdk:8-jre
COPY target/vue_starter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]