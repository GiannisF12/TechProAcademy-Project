# TechProAcademy Project

## 📦 Part 1: Java Servlet (`ProxySystem`)

This part demonstrates a basic Java Servlet implementation deployed on a standalone Tomcat server (non-Docker). It acts as a proxy endpoint to test connectivity and potentially forward to a Swagger UI from the Spring Boot service.

### 🧱 Technologies Used

- Java 21
- Java Servlet API (`javax.servlet.http.HttpServlet`)
- Tomcat (local installation)
- IntelliJ IDEA Ultimate (JavaX project)

### 📁 Project Structure

```
ProxySystem/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/giannis_foras/proxysystem/
│       │       └── ProxySystem.java
│       └── webapp/
│           └── WEB-INF/
│               └── web.xml (if used)
├── pom.xml
```

### 🚀 How to Deploy

1. Open IntelliJ IDEA Ultimate as a Jakarta EE project.
2. Set up a local Tomcat server (installed manually, not Docker).
3. Build the WAR artifact from the project.
4. Deploy it to `webapps/` inside Tomcat.
5. Start the Tomcat server.

### 📌 Access the Servlet

- URL: [http://localhost:8080/ProxySystem-1.0-SNAPSHOT/proxy-system](http://localhost:8080/ProxySystem-1.0-SNAPSHOT/proxy-system)
- ✅ Output: `System reached`

### ✅ Servlet Requirements Covered

- `@WebServlet("/proxy-system")` annotation used ✅
- Extends `HttpServlet` and overrides `doGet()` ✅
- Optional `RequestDispatcher` line to forward to Swagger UI (commented) ✅
- Tested via browser/Postman ✅

---

## 📦 Part 2: Spring Boot REST API (`ProductService`)

This is a full REST API application using Spring Boot. It connects to a PostgreSQL database, uses Spring Security for protection, and is fully containerized using Docker and Docker Compose.

### 🧱 Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Security
- PostgreSQL + Docker
- PgAdmin
- Lombok
- Maven
- Postman

### 📁 Project Structure

```
ProductService/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/giannis_foras/ProductService/
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       ├── repository/
│   │   │       │   └── ProductRepository.java
│   │   │       ├── security/
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── service/
│   │   │       │   ├── ProductService.java
│   │   │       │   └── ProductServiceImpl.java
│   │   │       └── ProductServiceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── Dockerfile
├── docker-compose.yml
├── schema.sql
├── pom.xml
├── .gitignore
└── README.md
```

### 🚀 How to Run (Spring Boot + PostgreSQL + PgAdmin)

```bash
./mvnw clean package -DskipTests
docker-compose up --build
```

### 🔐 Credentials

- App: [http://localhost:8080](http://localhost:8080)
- PgAdmin: [http://localhost:5050](http://localhost:5050)
  - Email: `admin@admin.com`
  - Password: `admin`
- Spring Security:
  - Username: `admin`
  - Password: `admin`

### 🧩 REST API Endpoints

| Method | Endpoint                | Description         |
| ------ | ----------------------- | ------------------- |
| GET    | `/products`             | Get all products    |
| GET    | `/products/{id}`        | Get product by ID   |
| GET    | `/products/name/{name}` | Get product by name |
| POST   | `/products`             | Add a new product   |
| PUT    | `/products/{id}`        | Update a product    |
| DELETE | `/products/{id}`        | Delete a product    |

### 🧪 Sample cURL Requests

```bash
# Get all
curl -u admin:admin http://localhost:8080/products

# Create new
curl -X POST http://localhost:8080/products \
  -u admin:admin \
  -H "Content-Type: application/json" \
  -d '{"name": "Tablet", "price": 450.00}'

# Update
curl -X PUT http://localhost:8080/products/1 \
  -u admin:admin \
  -H "Content-Type: application/json" \
  -d '{"name": "Updated Tablet", "price": 500.00}'

# Delete
curl -X DELETE http://localhost:8080/products/1 -u admin:admin
```

### 🧾 Data Initialization

The database is initialized using `schema.sql`:

```sql
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

INSERT INTO products (name, price) VALUES
('Laptop', 1200.00),
('Smartphone', 799.99),
('Tablet', 450.00),
('Monitor', 199.99),
('Keyboard', 49.99);
```

---

## 🙌 Thank You

