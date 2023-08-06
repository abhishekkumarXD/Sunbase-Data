# Sunbase-Data

# Customer Management System - Backend

This is the backend implementation for the Customer Management System project. It provides REST API endpoints for managing customer records. The backend is developed using Java with Spring Boot framework.
### Screenshots
Screenshots of the API endpoints being hit:
- **Login screen**: <br>
![image](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/d4db0bcd-876d-4c43-a7c4-f7bf4515d23c)

- **Add Customer Details screen**: <br>
  ![image](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/5e5024a6-4e13-4238-87e3-5d6e11cf1112)

- **Authenticate User**: <br>
  ![auth](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/9850d693-7c7f-47e5-8fb9-a0cc8ba01de3)

- **Create a New Customer**: <br>
  ![create_customer](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/fefc5ba3-beec-4d74-8c7b-3a0f8b8a3d6b)

- **Delete a Customer**: <br>
 ![delete_customer](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/a1b1b88e-9e65-4c8f-bc66-8cf18cfd3e07)

- **Get Customer List**: <br>
  ![get_customer_list](https://github.com/abhishekkumarXD/Sunbase-Data/assets/95921032/130071cd-fa4d-4a56-8500-c8e92cc2c09a)

- **Notes** <br>
  Please ensure that you have the necessary authorization token (Bearer token) to access the API endpoints. The token is obtained through the authentication API endpoint and should be included in the request headers for all protected endpoints.

## Getting Started

To run the backend server locally, follow the steps below:

1. Clone the repository to your local machine.
2. Navigate to the root folder of the backend project.
3. Make sure you have Java and Maven installed on your machine.
4. Open the terminal and run the following command to start the backend server:
   mvn spring-boot:run

markdown
Copy code
5. The backend server should now be up and running at `http://localhost:8080`.

## API Endpoints

### 1. Authenticate User

- **Endpoint**: `POST /sunbase/portal/api/assignment_auth.jsp`
- **Description**: This endpoint is used to authenticate a user.
- **Request Body**:
```json
{
 "loginId": "test@sunbasedata.com",
 "password": "Test@123"
}
```
- **Response**:   <br>
Status: 200 OK  <br>
Body: Bearer token (authorization token)
### 2. Create a New Customer
- **Endpoint**: POST /sunbase/portal/api/assignment.jsp`
- **Description**: This endpoint is used to create a new customer.
- **Request Headers**:
Authorization: Bearer {token_received_in_authentication_API_call}
- **Request Body**:
```
{
  "firstName": "John",
  "lastName": "Doe",
  "street": "123 Main St",
  "address": "Apt 5",
  "city": "New York",
  "state": "NY",
  "email": "john.doe@example.com",
  "phone": "123-456-7890"
}
```
- **Response**: <br>
Status: 201 Created <br>
Body: "Successfully Created"

### 3. Update a Customer
- **Endpoint**: POST /sunbase/portal/api/assignment.jsp
- **Description**: This endpoint is used to update an existing customer.
- **Request Headers**:
Authorization: Bearer {token_received_in_authentication_API_call}
Request Body:
```
{
  "cmd": "update",
  "uuid": "{customer_uuid}",
  "first_name": "Jane",
  "last_name": "Doe",
  "street": "Elvnu Street",
  "address": "H no 2 ",
  "city": "Delhi",
  "state": "Delhi",
  "email": "jane.doe@example.com",
  "phone": "9876543210"
}
```
- **Response**: <br>
Status: 200 OK <br>
Body: "Successfully Updated"
### 4. Delete a Customer
- **Endpoint**: POST /sunbase/portal/api/assignment.jsp
- **Description**: This endpoint is used to delete a customer.
- **Request Headers**:
- **Authorization**: Bearer {token_received_in_authentication_API_call}
- **Request Body**:
```
{
  "cmd": "delete",
  "uuid": "{customer_uuid}"
}
```
- **Response**: <br>
Status: 200 OK  <br>
Body: "Successfully Deleted"
### 5. Get Customer List
- **Endpoint**: GET /sunbase/portal/api/assignment.jsp
- **Description**: This endpoint is used to retrieve the list of all customers.
- **Request Headers**:
- **Authorization**: Bearer {token_received_in_authentication_API_call}
- **Response**: <br>
Status: 200 OK <br>
Body: Array of customer objects
