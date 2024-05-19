FROM openjdk:22-jdk as build
WORKDIR /tmp/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && ./mvnw install -DskipTests

FROM eclipse-temurin:22-jre-alpine
WORKDIR /app

COPY --from=build /tmp/app/target/*.jar /app/app.jar 
CMD [ "java", "-jar", "/app/app.jar" ]
