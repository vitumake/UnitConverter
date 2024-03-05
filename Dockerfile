# Start with a base image containing Java runtime
FROM maven:latest AS build

# The application's .jar file will reside in /usr/src/app
WORKDIR /usr/src/app

# Copy the pom.xml file
COPY ./projteht/pom.xml ./pom.xml

# Package the application
RUN mvn dependency:go-offline -B

# Copy your other files
COPY ./projteht/src ./src

# Build the application
RUN mvn clean package

# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file
COPY --from=build /usr/src/app/target/*.jar ./app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app/app.jar"]