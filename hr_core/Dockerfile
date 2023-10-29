#FROM node:12.20.1-alpine3.10 as nodejs
FROM node:18-alpine3.15 as nodejs
WORKDIR /app
COPY . .
RUN unset NODE_OPTIONS
RUN  apk add --update --no-cache python2.7 git make g++
RUN git config --global url."https://github.com".insteadOf git://github.com
RUN npm install -g node-gyp && npm install
RUN npm run prod

FROM maven:3.8.6-eclipse-temurin-17 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
COPY --from=nodejs /app/src/main/resources/static/js/dist /workspace/src/main/resources/static/js/dist
RUN mvn -B -f pom.xml clean package -DskipTests


FROM eclipse-temurin:21_35-jre-alpine
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
