# Calculator API

## Overview

The Calculator API provides endpoints for performing basic arithmetic operations such as addition, subtraction, multiplication, and division. This API allows users to perform calculations through RESTful endpoints and supports chaining multiple operations sequentially.

## Features

- **Basic Operations**: Supports `ADD`, `SUBTRACT`, `MULTIPLY`, and `DIVIDE`.
- **Chaining Operations**: Apply multiple operations in sequence on a single value.
- **OpenAPI Documentation**: Interactive API documentation provided by OpenAPI(SwaggerUI)
- **Error Handling**: Handles invalid operations and division by zero gracefully.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6.0 or later

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/kenwan006/calculator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd calculator
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:

   ```bash
   mvn spring-boot:run
   ```


## API Endpoints

### Calculate

- **Endpoint:** `GET /api/calculator/calculate`
- **Description:** Perform a calculation based on the specified operation and numbers.

#### Parameters:

- `op` (required): Operation to perform. Valid values are `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`.
- `num1` (required): The first number.
- `num2` (required): The second number.

#### Responses:

- `200 OK`: Returns the result of the calculation.

  **Example Response:**

  ```json
  {
    "result": 8
  }
  ```


### Chain Operations

- **Endpoint:** `POST /api/calculator/chain`
- **Description:** Perform a series of calculations in sequence starting with an initial value.

#### Request Parameters

- **Query Parameter:**
  - `initialValue` (required): The starting value for the chain of operations. This parameter should be included in the query string.

#### Request Body

- **Content-Type:** `application/json`
- **Schema:**

  ```json
  {
    "operations": ["ADD", "MULTIPLY", "SUBTRACT"],
    "values": [3, 2, 5]
  }
  ```



Feel free to adjust or expand this based on any additional details or specific formats required for your documentation.

