# API Automation Framework

A Java-based API automation framework built using Rest Assured, TestNG, Maven, and Jackson.

The framework demonstrates API testing using a layered structure with reusable API methods, request/response models, test data management, response validation, configuration management, and TestNG listeners.

## Tech Stack

- Java 17
- Maven
- Rest Assured 5.5.6
- TestNG 7.12.0
- Jackson Databind 2.20.0
- DummyJSON API

## Framework Structure

    api-automation/
    │
    ├── .gitignore
    ├── pom.xml
    ├── testng.xml
    ├── README.md
    │
    └── src/
        ├── main/
        │   └── java/
        │       ├── api/
        │       │   └── UserApi.java
        │       │
        │       ├── constants/
        │       │   └── ApiEndpoints.java
        │       │
        │       ├── models/
        │       │   ├── UserRequest.java
        │       │   └── UserResponse.java
        │       │
        │       └── utils/
        │           ├── ConfigReader.java
        │           └── ResponseValidator.java
        │
        └── test/
            ├── java/
            │   ├── base/
            │   │   └── BaseTest.java
            │   │
            │   ├── data/
            │   │   └── UserTestData.java
            │   │
            │   ├── listeners/
            │   │   └── TestListener.java
            │   │
            │   └── tests/
            │       ├── CreateUserTest.java
            │       ├── GetUserTest.java
            │       ├── GetInvalidUserTest.java
            │       ├── UpdateUserTest.java
            │       └── DeleteUserTest.java
            │
            └── resources/
                └── config.properties

## Framework Architecture

    Test Classes
         ↓
       UserApi
         ↓
     Rest Assured
         ↓
     DummyJSON API

    Test Data → Models → API Layer
                             ↓
                     Response Validation
                             ↓
                       Test Listener

### Main Components

**BaseTest**
- Creates the reusable Rest Assured `RequestSpecification`
- Reads the base URL from configuration

**ConfigReader**
- Reads configuration values from `config.properties`

**ApiEndpoints**
- Stores API endpoint paths as constants

**UserApi**
- Contains reusable API methods for user operations
- Keeps API interaction separate from test logic

**Models**
- `UserRequest` represents request data
- `UserResponse` represents the deserialized create-user response

**UserTestData**
- Centralizes test data used by the test cases

**ResponseValidator**
- Provides reusable response status-code validation

**TestListener**
- Reports test execution results through TestNG

## Test Coverage

The framework currently covers:

| API Operation | Test |
|---|---|
| Create User | `CreateUserTest` |
| Get User | `GetUserTest` |
| Get Invalid User | `GetInvalidUserTest` |
| Update User | `UpdateUserTest` |
| Delete User | `DeleteUserTest` |

### TestNG Groups

- `smoke`
- `regression`
- `negative`

## Running the Tests

Make sure Maven and Java 17 are installed.

Run the complete test suite from the project root:

    mvn clean test

The suite is configured through:

    testng.xml

## Configuration

The base URL is maintained separately in:

    src/test/resources/config.properties

Example:

    baseUrl=https://dummyjson.com

This keeps environment-specific configuration outside the test classes.

## Example Test Flow

A typical test follows this structure:

    Test Data
        ↓
    API Method
        ↓
    HTTP Request
        ↓
    HTTP Response
        ↓
    Status Code Validation
        ↓
    Response Data Assertion

This keeps test classes focused on **what is being tested**, while API request implementation remains inside the API layer.

## Project Goals

This framework was created to demonstrate practical API automation concepts including:

- REST API automation with Rest Assured
- GET, POST, PUT and DELETE requests
- Request and response serialization/deserialization
- Reusable request specifications
- Centralized configuration
- Test data management
- Response validation
- TestNG grouping
- Test listeners
- Maven-based test execution
- Layered test automation architecture