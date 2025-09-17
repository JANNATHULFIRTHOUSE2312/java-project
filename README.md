# 🛒 **ORDERuP** – Reliable Order Processing System for Growing Shops

**ORDERuP** is a Spring Boot–based backend service designed to handle **concurrent product orders** reliably. It ensures **thread-safe stock management**, provides **clear error handling**, and is backed by **robust test coverage** using JUnit and JaCoCo.

---

## 🚀 Key Highlights

| Feature                          | Description                                                              |
| -------------------------------- | ------------------------------------------------------------------------ |
| 🛍️ Reliable Order API           | Exposes a clean RESTful endpoint to process product orders               |
| 🔐 Thread-Safe Inventory Control | Prevents double-selling even under high concurrency                      |
| ⚠️ Smart Error Handling          | Structured error responses via global exception handler                  |
| 📦 Clean Architecture            | Uses DTOs and layered service-controller structure                       |
| 🧪 Test Coverage                 | Unit + integration tests with over 80% line coverage on critical classes |

---

## 🧠 System Architecture Overview

| Layer          | Role                                                             |
| -------------- | ---------------------------------------------------------------- |
| **Controller** | Accepts HTTP requests and sends responses                        |
| **Service**    | Handles business logic like product lookup and stock reservation |
| **Entity/DTO** | Entities for persistence, DTOs for API input/output separation   |
| **AOP**        | Used for logging execution time of business operations           |
| **Exception**  | Centralized handler returns proper HTTP status and messages      |

---

## 🔄 Order Processing Flow

```plaintext
Client
  |
  v
+------------------+       +---------------------+       +----------------+
|  OrderController | ----> |   OrderService      | ----> | Product Entity |
+------------------+       +---------------------+       +----------------+
      |                            |                           |
      |                            v                           |
      |              [Validate product & stock]                |
      |                            |                           |
      |                       [Reserve stock] <--- (Thread-safe)
      |                            |
      |                    [Create Order record]
      |                            |
      |               [Return OrderResponse DTO]
      |                            |
      v                            v
  +-------------+         +---------------------+
  | Success 200 |         | Fail: 400 / 404 / 500|
  +-------------+         +---------------------+
```

---

## 📬 API Workflow

### 🔹 Endpoint: `POST /orders`

* **Request Format:**

```json
{
  "productId": 1,
  "quantity": 2
}
```

* **Response on Success:**

```json
{
  "orderId": 101,
  "productId": 1,
  "quantity": 2,
  "status": "CONFIRMED"
}
```

---

### ❌ Error Scenarios

| Case                   | HTTP Code | Example Message          |
| ---------------------- | --------- | ------------------------ |
| Product does not exist | 404       | `"Product not found"`    |
| Not enough stock       | 400       | `"Insufficient stock"`   |
| Unknown server issue   | 500       | `"Something went wrong"` |

---

## 🧪 Testing Strategy

| Test Type         | Tools Used            | Covers                                   |
| ----------------- | --------------------- | ---------------------------------------- |
| ✅ Unit Tests      | JUnit 5, Mockito      | Business logic in `OrderService`         |
| ✅ Integration     | Spring Boot + MockMvc | End-to-end API testing                   |
| ✅ Coverage Report | JaCoCo                | `OrderService`, `GlobalExceptionHandler` |

### Run tests and view coverage:

```bash
mvn clean test
mvn jacoco:report
```

Open the report:

```
target/site/jacoco/index.html
```

Expected: **80%+ line coverage**

---

## 🛠 How to Run the Project

1. Start the app:

```bash
mvn spring-boot:run
```

2. Access endpoints at:

```
http://localhost:8080/orders
```

---

## 🔍 Example Requests (with curl)

### ✅ Place Order

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"productId": 1, "quantity": 2}'
```

### ❌ Product Not Found

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"productId": 999, "quantity": 1}'
```

### ❌ Insufficient Stock

```bash
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"productId": 1, "quantity": 1000}'
```

---

## 📦 Tech Stack

| Technology        | Purpose                            |
| ----------------- | ---------------------------------- |
| Java 17           | Core programming language          |
| Spring Boot 3.x   | Backend framework                  |
| Spring Web        | REST controller and routing        |
| Spring Data JPA   | ORM and database access            |
| Spring AOP        | Logging and performance timing     |
| H2 Database       | In-memory database for development |
| JUnit 5 + Mockito | Unit testing framework             |
| MockMvc           | Integration testing                |
| JaCoCo            | Code coverage reporting            |

---

## ✅ Summary

**SafeCart** is built to help fast-growing small businesses handle inventory and orders without crashing under load. It combines:

* A clean, modular Spring Boot design
* Thread-safe stock handling
* Robust test and coverage setup
* Clear, centralized error handling

With this foundation, your business backend is ready to scale with confidence.

---

Would you like this delivered as a downloadable `README.md` file? I can also turn it into a **PDF for submission**, or help you brand it further with your name/logo!
