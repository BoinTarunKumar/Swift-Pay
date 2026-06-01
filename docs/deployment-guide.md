# Deployment Guide

## Prerequisites

- Java 21
- Docker
- Docker Compose
- Maven 3.9+
- Git

---

## Clone Repository

```bash
git clone https://github.com/username/swiftpay.git

cd swiftpay
```

---

## Build Project

```bash
mvn clean install
```

---

## Start Infrastructure

```bash
docker-compose up -d
```

Verify Containers

```bash
docker ps
```

---

## Run Services

Gateway

```bash
cd transaction-gateway-service

mvn spring-boot:run
```

Ledger

```bash
cd ledger-service

mvn spring-boot:run
```

Analytics

```bash
cd analytics-service

mvn spring-boot:run
```

---

## Swagger URLs

Gateway

```text
http://localhost:8080/swagger-ui.html
```

Ledger

```text
http://localhost:8081/swagger-ui.html
```

Analytics

```text
http://localhost:8082/swagger-ui.html
```

---

## Health Checks

```text
http://localhost:8080/actuator/health

http://localhost:8081/actuator/health

http://localhost:8082/actuator/health
```

---

## Stop Environment

```bash
docker-compose down
```