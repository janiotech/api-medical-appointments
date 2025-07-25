# Etapa 1: build
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app
COPY ./ .
RUN ./gradlew bootJar --no-daemon

# Etapa 2: imagem final
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
