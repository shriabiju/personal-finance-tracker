# 💰 Personal Finance Tracker

A full-stack web application built using **Java Spring Boot** and **MySQL** that helps users manage personal finances by tracking expenses, monitoring budgets, and visualizing spending analytics.

---

## 🚀 Project Overview

The Personal Finance Tracker is designed to simplify financial management through an intuitive dashboard and powerful backend APIs. Users can:

* Register and log in securely
* Add, update, and delete expenses
* Set monthly budgets
* Track category-wise spending
* Monitor remaining budget
* View analytics and charts through a responsive dashboard

This project follows a clean layered architecture using:

```text
Controller → Service → Repository → Database
```

making it scalable, maintainable, and aligned with enterprise Java development practices.

---

## ⭐ Key Highlights

* Built using Java 17 and Spring Boot 3
* RESTful API architecture
* MySQL database integration using Spring Data JPA
* Layered backend architecture
* DTO-based data transfer
* Expense analytics and dashboard insights
* Responsive frontend using Bootstrap 5
* Category-wise expense tracking
* Monthly budget monitoring
* Maven-based project management

---

## 🛠️ Tech Stack

### Backend

| Technology      | Purpose                     |
| --------------- | --------------------------- |
| Java 17         | Core programming language   |
| Spring Boot 3   | Backend framework           |
| Spring MVC      | REST API development        |
| Spring Data JPA | ORM and database operations |
| Hibernate       | JPA implementation          |
| Maven           | Dependency management       |
| Lombok          | Boilerplate code reduction  |

---

### Frontend

| Technology  | Purpose                 |
| ----------- | ----------------------- |
| HTML5       | Structure               |
| CSS3        | Styling                 |
| JavaScript  | Client-side logic       |
| Bootstrap 5 | Responsive UI           |
| Chart.js    | Analytics visualization |

---

### Database

| Technology | Purpose             |
| ---------- | ------------------- |
| MySQL      | Relational database |

---

## 📌 Features

### 🔐 Authentication

* User Registration
* User Login
* User Profile Retrieval

### 💸 Expense Management

* Add Expenses
* Edit Expenses
* Delete Expenses
* View Expense History
* Filter Expenses by Category
* Filter Expenses by Date Range

### 🎯 Budget Management

* Set Monthly Budget
* Update Monthly Budget
* Track Remaining Budget

### 📊 Dashboard & Analytics

* Total Monthly Spending
* Category-wise Expense Analysis
* Pie Chart Visualization
* Monthly Spending Insights

### 📱 User Interface

* Responsive Bootstrap UI
* Dashboard Cards
* Expense Tables
* Analytics Charts

---

## 📂 Project Structure

```text
personal-finance-tracker/
│
├── src/
│   └── main/
│       ├── java/com/finance/tracker/
│       │
│       │   ├── controller/
│       │   │   ├── UserController.java
│       │   │   ├── ExpenseController.java
│       │   │   ├── BudgetController.java
│       │   │   └── DashboardController.java
│       │   │
│       │   ├── service/
│       │   │   ├── UserService.java
│       │   │   ├── ExpenseService.java
│       │   │   ├── BudgetService.java
│       │   │   └── DashboardService.java
│       │   │
│       │   ├── repository/
│       │   │   ├── UserRepository.java
│       │   │   ├── ExpenseRepository.java
│       │   │   └── BudgetRepository.java
│       │   │
│       │   ├── model/
│       │   │   ├── User.java
│       │   │   ├── Expense.java
│       │   │   └── Budget.java
│       │   │
│       │   ├── dto/
│       │   │   ├── UserDTO.java
│       │   │   ├── ExpenseDTO.java
│       │   │   ├── BudgetDTO.java
│       │   │   └── DashboardDTO.java
│       │   │
│       │   └── FinanceTrackerApplication.java
│       │
│       └── resources/
│           ├── static/
│           │   ├── login.html
│           │   ├── register.html
│           │   ├── dashboard.html
│           │   ├── expenses.html
│           │   └── budget.html
│           │
│           └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🗄️ Database Schema

### Users Table

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
```

### Expenses Table

```sql
CREATE TABLE expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    date DATE NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

### Budgets Table

```sql
CREATE TABLE budgets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    monthly_limit DOUBLE NOT NULL,
    month VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

---

## 🔌 REST API Endpoints

### User APIs

| Method | Endpoint              | Description         |
| ------ | --------------------- | ------------------- |
| POST   | `/api/users/register` | Register new user   |
| POST   | `/api/users/login`    | Login existing user |
| GET    | `/api/users/{id}`     | Get user by ID      |

---

### Expense APIs

| Method | Endpoint                                          | Description                   |
| ------ | ------------------------------------------------- | ----------------------------- |
| POST   | `/api/expenses`                                   | Add expense                   |
| GET    | `/api/expenses/user/{userId}`                     | Get all expenses              |
| GET    | `/api/expenses/user/{userId}/category/{category}` | Filter expenses by category   |
| GET    | `/api/expenses/user/{userId}/date?start=&end=`    | Filter expenses by date range |
| PUT    | `/api/expenses/{id}`                              | Update expense                |
| DELETE | `/api/expenses/{id}`                              | Delete expense                |
| GET    | `/api/expenses/user/{userId}/total`               | Get total spending            |

---

### Budget APIs

| Method | Endpoint                                             | Description          |
| ------ | ---------------------------------------------------- | -------------------- |
| POST   | `/api/budgets`                                       | Set or update budget |
| GET    | `/api/budgets/user/{userId}/month/{month}`           | Get monthly budget   |
| GET    | `/api/budgets/user/{userId}/month/{month}/remaining` | Get remaining budget |

---

### Dashboard APIs

| Method | Endpoint                                     | Description             |
| ------ | -------------------------------------------- | ----------------------- |
| GET    | `/api/dashboard/user/{userId}/month/{month}` | Get dashboard analytics |

---

## ⚙️ Installation & Setup

### Prerequisites

Ensure the following are installed:

* Java 17
* Maven 3.9+
* MySQL 8+
* Git
* VS Code / IntelliJ IDEA

---

## ▶️ Run Locally

### 1. Clone Repository

```bash
git clone https://github.com/shriabiju/personal-finance-tracker.git
cd personal-finance-tracker
```

---

### 2. Create Database

```sql
CREATE DATABASE finance_tracker;
```

---

### 3. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_tracker
spring.datasource.username=root
spring.datasource.password=your_password
```

---

### 4. Install Dependencies

```bash
mvn clean install
```

---

### 5. Run Application

```bash
mvn spring-boot:run
```

---

### 6. Open in Browser

```text
http://localhost:8080/login.html
```

---

## 📸 Screenshots

### Login Page

<img width="1919" height="871" alt="image" src="https://github.com/user-attachments/assets/c4db711d-5ac5-4c5e-a470-1980d63d74a8" />
</br>
<img width="1919" height="870" alt="image" src="https://github.com/user-attachments/assets/c0415411-8922-430b-be56-79e0b1e85461" />



### Dashboard

<img width="1896" height="866" alt="image" src="https://github.com/user-attachments/assets/75139ae4-363f-41b6-be35-3aa696c18b61" />
</br>
<img width="1897" height="879" alt="image" src="https://github.com/user-attachments/assets/5b22edaa-0a2d-438b-8b4f-85a5ffa40312" />


### Expense Management

<img width="1919" height="866" alt="image" src="https://github.com/user-attachments/assets/8aa92efd-aa76-4560-ad84-fd9440899a42" />


### Budget Management

<img width="1917" height="859" alt="image" src="https://github.com/user-attachments/assets/d1029db2-a8a7-479d-af2d-5f4686564c1e" />


---

## 🚧 Future Enhancements

* JWT Authentication
* Password Encryption
* Email Notifications
* PDF Report Export
* Dark Mode
* Mobile Optimization
* Expense Prediction using ML

---

## 🧠 Concepts Used

* RESTful APIs
* CRUD Operations
* MVC Architecture
* DTO Pattern
* Dependency Injection
* ORM using JPA/Hibernate
* Relational Database Design
* Layered Architecture

---

## 👨‍💻 Author

### Shria Biju

* GitHub: [https://github.com/shriabiju](https://github.com/shriabiju)

---

## 📄 License

This project is licensed under the MIT License.
