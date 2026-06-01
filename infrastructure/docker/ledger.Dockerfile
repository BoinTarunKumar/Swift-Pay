# Build Stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -pl ledger-service -am -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder \
/app/ledger-service/target/ledger-service-1.0.0.jar \
ledger.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","ledger.jar"]