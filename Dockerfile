FROM openjdk:11-jre-slim

# Setting the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Gradle into the container
COPY build/libs/globe-mart-0.0.1-SNAPSHOT.jar .

# Port on which application runs
EXPOSE 9191

# ommand to run your Spring Boot application
CMD ["java", "-jar", "globe-mart-0.0.1-SNAPSHOT.jar"]
