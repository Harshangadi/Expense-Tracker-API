# 💸 Expense Tracker API

A simple REST API built with **Spring Boot** to track and manage personal expenses.

## ✅ Features
- Add, update, delete expenses
- View all expenses
- Filter by category
- Uses H2 in-memory DB
- RESTful architecture

## 🔧 Tech Stack
- Java 17+
- Spring Boot + Spring Data JPA
- H2 Database
- Lombok

## 🔗 API Endpoints

| Method | Endpoint                            | Description      |
| ------ | ----------------------------------- | ---------------- |
| POST   | `/api/expenses`                     | Create expense   |
| GET    | `/api/expenses`                     | Get all expenses |
| GET    | `/api/expenses/category/{category}` | Get by category  |
| PUT    | `/api/expenses/{id}`                | Update expense   |
| DELETE | `/api/expenses/{id}`                | Delete expense   |
