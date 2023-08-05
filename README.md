# Sunbase-Data

# Customer Management System - Backend

This is the backend implementation for the Customer Management System project. It provides REST API endpoints for managing customer records. The backend is developed using Java with Spring Boot framework.

## Getting Started

To run the backend server locally, follow the steps below:

1. Clone the repository to your local machine.
2. Navigate to the root folder of the backend project.
3. Make sure you have Java and Maven installed on your machine.
4. Open the terminal and run the following command to start the backend server:
5. The backend server should now be up and running at `http://localhost:8080`.

## API Endpoints

### 1. Authenticate User

- Endpoint: `POST /sunbase/portal/api/assignment_auth.jsp`
- Description: This endpoint is used to authenticate a user.
- Request Body: 
```json
{
 "loginId": "test@sunbasedata.com",
 "password": "Test@123"
}
