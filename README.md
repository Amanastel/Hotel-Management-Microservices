# Hotel Management Microservices

Welcome to the Hotel Management Microservices project. This application is designed to manage various aspects of a hotel, including booking rooms, adding hotels, and handling user ratings.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features
This application provides the following features:

- **User Service**:
  - User registration and authentication.
  - User can book hotel rooms.
  - User can cancel bookings.
  - Wallet system to track all transactions for users.

- **Hotel Service**:
  - Add hotels with details.
  - Add rooms to hotels.
  - Get hotel details by ID or name.
  - Get a list of all available rooms in a hotel.
  - Get a list of all booked rooms in a hotel.

- **Booking Service**:
  - Book rooms in hotels.
  - Get booking details by booking ID.
  - Get a list of all bookings.

- **Rating Service**:
  - Add ratings and reviews for hotels.
  - Get all ratings.
  - Get ratings by user ID or hotel ID.

- **Service Registry**:
  - Register and discover microservices.
  
- **Configuration Server**:
  - Manage centralized configurations for microservices.
  
- **API Gateway**:
  - Gateway for accessing microservices.

## Tech Stack
- Java
- Spring Boot
- Spring Cloud
- Spring Cloud Eureka
- Spring Cloud Config
- Spring Security
- OAuth 2.0
- Spring Data JPA
- Spring Web
- Spring Data MongoDB
- Spring Data REST
- Spring Cloud Gateway
- Netflix Eureka
- Thymeleaf
- MySQL
- MongoDB
- Okta
- Git

## Getting Started
To get started with the project, make sure you have the required tools and dependencies installed.

### Installation
1. Clone this repository: `git clone https://github.com/Amanastel/Hotel-Management-Microservices.git`
2. Navigate to the project directory: `cd Hotel-Management-Microservices`

### Configuration
- Configure the properties of each microservice according to your requirements.

### Usage
- Run each microservice individually to start the Hotel Management system.

### API Endpoints
- Explore the API endpoints of each microservice by referring to their respective source code.

## Contributing
Contributions are welcome. Please create an issue or pull request if you'd like to contribute to this project.

## License
This project is licensed under the [MIT License](LICENSE).
