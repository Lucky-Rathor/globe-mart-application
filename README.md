# Globe Mart Application

## Overview

The Globe Mart Application is a Java-based project that uses Spring Boot for building a RESTful web service. It utilizes PostgreSQL as the database and is built using Gradle.

## Prerequisites

- Java 11
- Spring Boot 2.3.4
- PostgreSQL
- Gradle
- Git
- Hibernate ORM

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/Lucky-Rathor/globe-mart-application.git
cd globe-mart-application

**## Updating Database Configuration**
In the application.yml file, locate the spring.datasource section and update the following fields with your database information:

**url**: Replace Globel with your actual database name.
**username**: Replace postgres with your database username.
**password**: Replace Lucky@25198 with your database password.

**## Building the Project**
Use Gradle to build the project. Navigate to the project directory and run below command:
./gradlew clean build

**## Running the Application **
To run the application locally :- ./gradlew bootRun

**## API Endpoints**
Here are some of the primary endpoints for the Globe Mart Application:

GET /products - To retrieve all products.
POST /product - To create a new product.
GET /customers - To retrieve all customers.
POST /customer - To create a new customer.

Usage
Use any REST API client (e.g., Postman) to interact with the provided endpoints.
Authenticate using the provided authentication mechanism (e.g., JWT token) before accessing secure endpoints.

Contribution
Contributions are welcome! If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

**## Contact**
For any inquiries or support, please contact [Lucky Rathore](mailto: rlucky2000@gmail.com).
