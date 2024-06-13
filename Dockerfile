FROM maven:3.9.6-sapmachine-17 AS build
COPY . .
RUN  mvn clean package

FROM amazoncorretto:17

COPY --from=build odds-container/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

