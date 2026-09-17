# Video Rental Advanced System App

A backend application for managing a video rental system with **Customer** and **Admin** roles. The application provides video management, rental, return, user registration, and JWT-based authentication.

## 🚀 Functionalities Implemented

### 👤 Customer

Customers can:

* Read available videos
* Rent up to **2 videos**
* Return rented videos

### 🛡️ Admin

Administrators can perform full video management and rental operations:

* Create videos
* Read videos
* Update videos
* Delete videos
* Rent up to **2 videos**
* Return rented videos

## 🔐 Authentication

The application uses **JWT (JSON Web Token)** based authentication.

### Public Endpoints

The following endpoints are publicly accessible:

* **Register** — Create a new user account
* **Login** — Authenticate a user and receive a JWT token

Authenticated endpoints require the JWT token to access protected resources.

## 🏗️ Technology Stack

* **Java**
* **Spring Boot**
* **Spring Security**
* **JWT Authentication**
* **MySQL**
* **Gradle**
* **REST APIs**

## 📋 Prerequisites

Before running the application, make sure you have:

* Java installed
* MySQL installed and running
* Git installed
* Gradle Wrapper available in the project

## ⚙️ How to Execute the Application

### 1. Clone the Repository

```bash
git clone https://github.com/albinsanthosh/RentVideoAdvanced.git
cd RentVideoAdvanced
```

### 2. Create MySQL Database

Create a MySQL database for the application.

For example:

```sql
CREATE DATABASE video_rental;
```

### 3. Configure Database Properties

Update the application's database configuration with your MySQL credentials.

For example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/video_rental
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

> Update the property names and values according to the configuration used in the project.

### 4. Run the Application

Using the Gradle Wrapper:

```bash
./gradlew bootRun
```

On Windows:

```bash
gradlew.bat bootRun
```

The application should start successfully after the required configuration is completed.

## 🔄 Application Flow

```text
User
 │
 ├── Register
 │
 ├── Login
 │     │
 │     └── JWT Token
 │
 └── Authenticated Requests
       │
       ├── Customer
       │    ├── View Videos
       │    ├── Rent Videos
       │    └── Return Videos
       │
       └── Admin
            ├── Create Video
            ├── View Videos
            ├── Update Video
            ├── Delete Video
            ├── Rent Videos
            └── Return Videos
```

## 🔑 Role-Based Access

| Feature              | Customer |   Admin  |
| -------------------- | :------: | :------: |
| Register             |     ✅    |     ✅    |
| Login                |     ✅    |     ✅    |
| Read Videos          |     ✅    |     ✅    |
| Create Video         |     ❌    |     ✅    |
| Update Video         |     ❌    |     ✅    |
| Delete Video         |     ❌    |     ✅    |
| Rent Videos          |     ✅    |     ✅    |
| Return Videos        |     ✅    |     ✅    |
| Maximum Rental Limit | 2 Videos | 2 Videos |

## 📌 Project Repository

**GitHub:**
https://github.com/albinsanthosh/RentVideoAdvanced

## 📝 Notes

* Authentication is implemented using JWT.
* Access to video operations is controlled based on the user's role.
* Customers and administrators have different permissions.
* The rental system limits users to a maximum of **2 rented videos** at a time.
