# JobTrack — Job Application & Interview Management System

JobTrack is a full-stack web application designed to help users manage their job applications and interview rounds in one place.

Users can register and log in securely, track job applications, manage interview rounds, record feedback, and monitor their job search through a dashboard.

## Features

- User registration and login
- JWT-based authentication
- Spring Security protected APIs
- Create, view, update, and delete job applications
- Search and filter job applications
- Track application status
- View detailed application information
- Add, edit, and delete interview rounds
- Track interview date, time, mode, and status
- Store interviewer information and feedback
- User-specific application and interview access
- Input validation
- Centralized exception handling
- Dashboard with application, interview, offer, and rejection statistics
- Responsive and modern React UI

## Tech Stack

### Frontend
- React.js
- JavaScript
- React Router
- Axios
- HTML
- CSS
- Vite

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- JWT
- BCrypt
- Maven

### Database & Tools
- MySQL
- MySQL Workbench
- Postman
- Eclipse
- Visual Studio Code
- Git
- GitHub

### Deployment

- Render — Spring Boot Backend
- Aiven — MySQL Database
- Vercel — React Frontend

## Architecture

JobTrack follows a layered backend architecture:

```text
React Frontend
      ↓
     Axios
      ↓
Spring Boot REST API
      ↓
   Controller
      ↓
    Service
      ↓
   Repository
      ↓
   MySQL
```

### Authentication Flow

```text
User Login
    ↓
Spring Security
    ↓
JWT Token Generated
    ↓
Token Stored by Frontend
    ↓
JWT Sent with API Requests
    ↓
JwtAuthenticationFilter
    ↓
Protected Controller
```

## Backend Project Structure

    src/main/java/com/jobtrack
    │
    ├── config
    │   └── SecurityConfig.java
    │
    ├── controller
    │   ├── AuthController.java
    │   ├── JobApplicationController.java
    │   ├── InterviewController.java
    │   └── TestController.java
    │
    ├── dto
    │   ├── LoginRequest.java
    │   ├── LoginResponse.java
    │   ├── RegisterResponse.java
    │   ├── JobApplicationResponse.java
    │   └── InterviewResponse.java
    │
    ├── entity
    │   ├── User.java
    │   ├── JobApplication.java
    │   └── Interview.java
    │
    ├── enums
    │   ├── ApplicationStatus.java
    │   ├── InterviewMode.java
    │   └── InterviewStatus.java
    │
    ├── exception
    │   ├── GlobalExceptionHandler.java
    │   ├── ErrorResponse.java
    │   └── ...
    │
    ├── repository
    │   ├── UserRepository.java
    │   ├── JobApplicationRepository.java
    │   └── InterviewRepository.java
    │
├── security
│   ├── JwtService.java
│   ├── JwtAuthenticationFilter.java
│   └── CustomUserDetailsService.java    └── service
        ├── UserService.java
        ├── JobApplicationService.java
        └── InterviewService.java

## API Endpoints

### Authentication

- `POST /api/auth/register` — Register a new user
- `POST /api/auth/login` — Login and receive JWT

### Job Applications

- `POST /api/applications` — Create application
- `GET /api/applications` — Get user's applications
- `GET /api/applications/{id}` — Get application details
- `PUT /api/applications/{id}` — Update application
- `DELETE /api/applications/{id}` — Delete application

### Interviews

- `POST /api/applications/{applicationId}/interviews` — Add interview
- `GET /api/applications/{applicationId}/interviews` — Get interviews
- `PUT /api/applications/{applicationId}/interviews/{interviewId}` — Update interview
- `DELETE /api/applications/{applicationId}/interviews/{interviewId}` — Delete interview

## 🔐 Security

JobTrack uses Spring Security and JWT authentication.

- Passwords are encrypted using BCrypt.
- JWT tokens are generated after successful login.
- Protected APIs require a valid JWT token.
- Users can access only their own applications and interviews.
- Registration responses do not expose user passwords.
- Database credentials are stored using environment variables.
- JWT secrets are stored using environment variables.

Required environment variables:

    DB_PASSWORD=your_mysql_password
    JWT_SECRET=your_jwt_secret

## Database Setup

For local development, create a MySQL database:

    CREATE DATABASE jobtrack;

Configure the database connection through environment variables.

The application uses Spring Data JPA and Hibernate to manage database entities and schema updates.

## Running the Backend

### Clone the repository

    git clone https://github.com/Techy-nithin/jobtrack-backend.git

### Configure environment variables

Set:

    DB_PASSWORD
    JWT_SECRET

### Run the application

On Windows:

    mvnw.cmd spring-boot:run

The backend will run at:

    http://localhost:8080
    
## 🌐 Deployment

The backend is deployed on Render and uses Aiven MySQL for the production database.

**Backend:**  
https://jobtrack-backend-to3h.onrender.com

**Frontend:**  
https://jobtrack-frontend-nine.vercel.app    

## 🔗 Frontend Repository

The React frontend is maintained separately:

https://github.com/Techy-nithin/jobtrack-frontend

## Testing

The application was tested for:

- User registration
- Login authentication
- Invalid credentials
- Duplicate email validation
- JWT authentication
- Protected routes
- Application CRUD operations
- Application search
- Application status filtering
- Interview CRUD operations
- Ownership and authorization checks
- Validation and exception handling
- Logout and protected route redirection

## Future Improvements

- Job application analytics
- Email reminders for interviews
- Resume management
- Job search API integration
- Automated testing
- Role-based access control

## Author

**G Nithin**

GitHub: https://github.com/Techy-nithin