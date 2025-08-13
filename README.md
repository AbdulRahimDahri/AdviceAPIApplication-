# 🧪 Java Developer Task — Advice API (CRUD + H2)

## 📌 Overview
This is a simple **Advice API** built using **Java Spring Boot** that allows you to perform CRUD operations on advice messages.  
It uses **H2 in-memory database** for quick testing and requires **no authentication** for API access.

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Spring Web
- Lombok

---

## 🚀 How to Run Locally

### 1️⃣ Clone the repository
```bash
git clone https://github.com/AbdulRahimDahri/AdviceAPIApplication-.git
cd AdviceAPIApplication
```

### 2️⃣ Build the project
```bash
mvn clean install
```

### 3️⃣ Run the application
```bash
mvn spring-boot:run
```

The app will start at:  
```
http://localhost:8080
```

---

## 💾 H2 Database Console
You can view the in-memory DB here:  
```
http://localhost:8080/h2-console
```
- **JDBC URL:** `jdbc:h2:mem:advice-db`
- **Username:** `sa`
- **Password:** *(leave blank)*

---

## 📡 API Endpoints

| Method | Endpoint | Description | Request Body (JSON) |
|--------|----------|-------------|---------------------|
| GET    | `/api/advice` | Get all advices | — |
| GET    | `/api/advice/{id}` | Get advice by ID | — |
| POST   | `/api/advice` | Add new advice | `{ "message": "Your advice here" }` |
| PUT    | `/api/advice/{id}` | Update existing advice | `{ "message": "Updated advice" }` |
| DELETE | `/api/advice/{id}` | Delete advice by ID | — |

---

## 📌 Example Request (POST)
**POST** `/api/advice`
```json
{
  "message": "Never stop learning"
}
```

---

## 📝 Notes
- The database is **in-memory**, so all data will reset after restarting the application.
- Default sample advices are inserted automatically when the app starts.

---

## ✨ Author
Developed by **Abdul Raheem** as part of a Java Developer Hiring Task.
