# Étape de build
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Étape de runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
