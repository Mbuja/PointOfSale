
# Bhadala api

A point of sale REST api meant to be integrated with numerous UI as required


# API Documentation

## Table of Contents
1. [Overview](#overview)
2. [Getting Started](#getting-started)
3. [Base URL](#base-url)
4. [API Documentation](#api-documentation)
5. [Authentication](#authentication)
6. [Endpoints](#endpoints)
    - [Get All Companies](#get-all-companies)
    - [Get Company by Name](#get-company-by-name)
7. [Error Handling](#error-handling)
8. [Examples](#examples)
9. [Contributing](#contributing)
10. [License](#license)

---

## Overview
This API allows users to interact with a system that provides information about companies. It supports operations such as retrieving company details and performing other operations.

---

## Getting Started
### Prerequisites
- **Java version:** 17 or higher
- **Javalin version:** 6.4.0
- Tools like Postman, Curl, or a browser for testing endpoints.

### Installation
Clone this repository and follow the steps below:
```bash
git clone https://github.com/Mbuja/PointOfSale.git
cd pos
mvn clean install
java -jar target/pos.jar
```

---

## Base URL
The base URL for this API is:

```
http://localhost:5001
```

---

## API Documentation
### Swagger UI
The API includes Swagger UI for an interactive documentation interface.

- **Swagger UI Path:** [`/docs`](http://localhost:5001/docs)  
- Use this interface to explore and test API endpoints directly in your browser.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
### Redoc
Redoc is also available for clean and user-friendly documentation rendering.

- **Redoc Path:** [`/redoc`](http://localhost:5001/redoc)

---

## Authentication
When the API requires authentication, the authentication mechanism will ne documented here:
- **API Key:** Api header key `Authorization: Bearer <API_KEY>`.
- **OAuth:** Include the token flow details.

---

## Endpoints

### Get Company by Name
**Description:** Retrieve details about a specific company by its name.

- **URL:** `/company/{name}`
- **Method:** `GET`
- **Path Parameter:**
  - `name` (string): The name of the company.
- **Response:**
  ```json
    {"id":0,
    "name":"Test Company",
    "email":"Company@mail.com",
    "address":"\"123 Company Road,Com Town\"","accountNumber":"6552104475",
    "description":
    "A test company used solely for the purpose of testing"
    }
  ```
- **Example Request:**
  ```bash
  curl -X GET http://http://localhost:5001/company/Test%20Company
  ```

---

## Error Handling
The API uses standard HTTP response codes to indicate the success or failure of an API request:
- `200 OK`: Request successful.
- `400 Bad Request`: Invalid request parameters.
- `404 Not Found`: The requested resource does not exist.
- `500 Internal Server Error`: An unexpected server error.

Example error response:
```json
{
  "error": "Company not found",
  "status": 404
}
```

---

## Examples
### Using Swagger UI
1. Navigate to [`http://localhost:5001/docs`](http://localhost:5001/docs) in your browser.
2. Explore the available endpoints and test them directly.

### Using Curl
Retrieve a specific company:
```bash
curl -X GET http://localhost:5001/company/Test%20Company
```

### Using Postman
1. Open Postman.
2. Create a new `GET` request.
3. Enter `http://localhost:5001/company/Test%20Company`.
4. Send the request.

---

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any bugs or feature requests.

### Local Setup for Development
1. Fork the repository.
2. Clone your forked repository:
   ```bash
   git clone https://github.com/Mbuja/PointOfSale.git
   ```
3. Create a feature branch:
   ```bash
   git checkout -b feature/new-feature
   ```
4. Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
5. Push and create a pull request.

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

