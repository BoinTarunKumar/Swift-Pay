# Build Stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -pl transaction-gateway-service -am -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder \
/app/transaction-gateway-service/target/transaction-gateway-service-1.0.0.jar \
gateway.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","gateway.jar"]