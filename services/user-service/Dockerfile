# Start from OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

# Expose port
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java","-jar","user-service.jar"]
