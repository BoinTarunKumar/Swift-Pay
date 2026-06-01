# Build Stage
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -pl analytics-service -am -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder \
/app/analytics-service/target/analytics-service-1.0.0.jar \
analytics.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","analytics.jar"]