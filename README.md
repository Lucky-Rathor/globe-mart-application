# Globe Mart Application

## Overview

The Globe Mart Application is a Java-based project built using the Spring Boot framework. It provides a RESTful web service for managing products and customers. The application uses PostgreSQL as its database and leverages Hibernate ORM for database interactions.

## Prerequisites

- Java 11
- Spring Boot 2.3.4
- PostgreSQL
- Gradle
- Git
- Hibernate ORM

## Getting Started

### Clone the Repository

Clone the repository: [globe-mart-application](https://github.com/Lucky-Rathor/EmployeeManagement.git)

cd globe-mart-application

## Updating Database Configuration
In the **application.yml** file, locate the spring.datasource section and update the following fields with your database information:

**url**: Replace Globel with your actual database name.

**username**: Replace postgres with your database username.

**password**: Replace Lucky@25198 with your database password.

## Building the Project
Use Gradle to build the project. Navigate to the project directory and run below command:

./gradlew clean build

## Running the Application
To run the application locally :- ./gradlew bootRun

## API Endpoints
Here are some of the primary endpoints for the Globe Mart Application:

GET /products - To retrieve all products.

POST /product - To create a new product.

GET /customers - To retrieve all customers.

POST /customer - To create a new customer.

## Usage
Use any REST API client (e.g., Postman) to interact with the provided endpoints.

Authenticate using the provided authentication mechanism (e.g., JWT token) before accessing secure endpoints.

## Contribution
Contributions are welcome! If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

## Contact
For any inquiries or support, please contact [Lucky Rathore](mailto: rlucky2000@gmail.com).
