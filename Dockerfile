#FROM node:12.20.1-alpine3.10 as nodejs
FROM node:12 as nodejs
WORKDIR /app
COPY . .
RUN npm install
RUN npm run prod

FROM maven:3.6.3-ibmjava-8-alpine AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
COPY --from=nodejs /app/src/main/resources/static/js/dist /workspace/src/main/resources/static/js/dist
RUN mvn -B -f pom.xml clean package -DskipTests


FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
