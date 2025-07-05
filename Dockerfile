# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Crea un directorio para la app
WORKDIR /app

# Copia el jar generado al contenedor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expone el puerto
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
