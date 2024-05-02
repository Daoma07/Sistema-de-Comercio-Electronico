FROM openjdk:21-slim AS builder

WORKDIR /app

# Copia el proyecto y compila
COPY . .
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:21-slim

COPY --from=builder /app/target/User_Service-0.0.1-SNAPSHOT.jar /app/microservicio-usuario.jar

ENTRYPOINT ["java", "-jar", "/app/microservicio-usuario.jar"]
