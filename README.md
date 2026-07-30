# E-Commerce Backend REST API
A fully functional and secure E-Commerce Backend REST API built with **Java Spring Boot** and **MySQL**. This project implements complete CRUD operations for Products, Categories, and Orders with **JWT Authentication** for secure access. 

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot 3.x | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT (JSON Web Token) | Secure Token Based Authentication |
| Spring Data JPA | Database Operations |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate Code |
| Maven | Build Tool |
| Postman | API Testing |

## Features

-  User Registration and Login with JWT Authentication
-  Secure Password Encryption using BCrypt
-  Product Management (Create, Read, Update, Delete)
-  Category Management with Product-Category Relationship
-  Order Management with Multiple Order Items
-  Automatic Total Amount Calculation
-  Order Status Tracking (PENDING → CONFIRMED → DELIVERED)
-  Global Exception Handling with Custom Error Responses
-  Protected APIs — Token Required for Access
-  Role Based Access Control

## Project Structure

```
src/main/java/com/ecommerce/backend/
├── controller/
│   ├── AuthController.java
│   ├── ProductController.java
│   ├── CategoryController.java
│   └── OrderController.java
├── service/
│   ├── UserService.java
│   ├── ProductService.java
│   ├── CategoryService.java
│   └── OrderService.java
├── repository/
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── CategoryRepository.java
│   ├── OrderRepository.java
│   └── OrderItemRepository.java
├── model/
│   ├── User.java
│   ├── Product.java
│   ├── Category.java
│   ├── Order.java
│   └── OrderItem.java
├── dto/
│   ├── RegisterRequest.java
│   ├── LoginRequest.java
│   ├── AuthResponse.java
│   ├── OrderRequest.java
│   └── OrderItemRequest.java
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
└── exception/
    ├── ResourceNotFoundException.java
    ├── ErrorResponse.java
    └── GlobalExceptionHandler.java
```

## API Endpoints

### Authentication APIs (Public)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

###  Product APIs (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/products | Get all products |
| GET | /api/products/{id} | Get product by ID |
| POST | /api/products | Add new product |
| PUT | /api/products/{id} | Update product |
| DELETE | /api/products/{id} | Delete product |

###  Category APIs (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/categories | Get all categories |
| GET | /api/categories/{id} | Get category by ID |
| POST | /api/categories | Add new category |
| PUT | /api/categories/{id} | Update category |
| DELETE | /api/categories/{id} | Delete category |

###  Order APIs (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/orders | Place new order |
| GET | /api/orders | Get all orders |
| GET | /api/orders/user/{userId} | Get orders by user |
| PUT | /api/orders/{id}/status | Update order status |
| DELETE | /api/orders/{id} | Cancel order |


##  How to Run

### Prerequisites
- Java 17
- MySQL
- Maven
- Postman (for API testing)

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/vijaypawar30/ecommerce-backend.git
```

**2. Create MySQL Database**
```sql
CREATE DATABASE ecommerce_db;
```

**3. Configure application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

**4. Run the application**
```bash
mvn spring-boot:run
```

**5. Test APIs using Postman**

### How to use JWT Authentication

**Step 1 — Register**
```json
POST /api/auth/register
{
    "name": "Your Name",
    "email": "your@email.com",
    "password": "yourpassword"
}
```

**Step 2 — Login and get token**
```json
POST /api/auth/login
{
    "email": "your@email.com",
    "password": "yourpassword"
}
```

**Step 3 — Use token in requests**


## 👨‍💻 Author

**Vijay Vishnu Pawar**

- 🎓 MCA Student at Savitribai Phule Pune University
- 💼 Java Full Stack Developer
- 🔗 LinkedIn: [linkedin.com/in/vijay-pawar-41a575380](https://linkedin.com/in/vijay-pawar-41a575380)
- 🐙 GitHub: [github.com/vijaypawar30](https://github.com/vijaypawar30)
- 📧 Email: vijaypawar6008@gmail.com

---

⭐ If you find this project helpful, please give it a star!
