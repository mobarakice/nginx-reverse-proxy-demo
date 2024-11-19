# Stage 1: Build the application
FROM gradle:8.11.0-jdk-21-and-23 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Stage 2: Run the application
FROM openjdk:21-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

ENV PORT=8080
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar"]