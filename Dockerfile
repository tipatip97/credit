FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app

RUN chmod +x mvnw
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
 
COPY src ./src
 
CMD ["./mvnw", "spring-boot:run"]