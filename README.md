# Hotel Management Microservices

Welcome to the Hotel Management Microservices project. This application is designed to manage various aspects of a hotel, including booking rooms, adding hotels, and handling user ratings.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Checking Service Status](#checking-service-status)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features
This application provides the following features:

### User Service
- User registration and authentication.
- User can book hotel rooms.
- User can cancel bookings.
- Wallet system to track all transactions for users.

### Hotel Service
- Add hotels with details.
- Add rooms to hotels.
- Get hotel details by ID or name.
- Get a list of all available rooms in a hotel.
- Get a list of all booked rooms in a hotel.

### Booking Service
- Book rooms in hotels.
- Get booking details by booking ID.
- Get a list of all bookings.

### Rating Service
- Add ratings and reviews for hotels.
- Get all ratings.
- Get ratings by user ID or hotel ID.

### Service Registry
- Register and discover microservices.

### Configuration Server
- Manage centralized configurations for microservices.

### API Gateway
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

### Checking Service Status
- **Eureka Server**:
  - Eureka Dashboard: `http://localhost:8761`
    - You can check the status of all registered microservices here. It will show which services are up and running and their corresponding instances.

Instances currently registered with Eureka:

- **API-GATEWAY**:
  - Availability Zones: UP (1) - `192.168.1.4:API-GATEWAY:8086`

- **CONFIG-SERVER**:
  - Availability Zones: UP (1) - `192.168.1.4:CONFIG-SERVER:8085`

- **HOTELS-SERVICE**:
  - Availability Zones: UP (1) - `192.168.1.4:hotels-service:8082`

- **RATING-SERVICE**:
  - Availability Zones: UP (1) - `192.168.1.4:rating-service:8083`

- **USERS-SERVICE**:
  - Availability Zones: UP (1) - `192.168.1.4:users-service:8081`

- **API Gateway Default URL**: `http://localhost:8086`

### User Service Routes
- User login: `http://localhost:8086/auth/login`
  - Login on this URL to obtain an access token. You can use this access token to make authenticated requests to other service endpoints.
- Fetch all users: `http://localhost:8086/users/all`
- User registration: `http://localhost:8086/users/register`
- User login: `http://localhost:8086/users/login`
- Book a hotel room: `http://localhost:8086/users/addBooking`
- Complete a Booking hotel: `http://localhost:8086/users/completeBooking/{bookingId}`
- Cancel a booking: `http://localhost:8086/users/cancelBooking/{bookingId}`
- Add wallet Balance transactions: `http://localhost:8086/users/wallet/addMoney/{email}?amount=00.0`
- View wallet Balance transactions: `http://localhost:8086/users/wallet/getBalance/{email}`
- View wallet transactions: `http://localhost:8086/users/wallet/getTransactions/{email}`

### Hotel Service Routes
- Fetch all hotels: `http://localhost:8086/hotels/all`
- Fetch hotel by ID: `http://localhost:8086/hotels/{hotelId}`
- Add a hotel: `http://localhost:8086/hotels/add`
- Add a room to a hotel: `http://localhost:8086/hotels/{hotelId}/rooms/add`
- Book a room in a hotel: `http://localhost:8086/hotels/{hotelId}/bookings/add`
- Get all bookings in a hotel: `http://localhost:8086/hotels/{hotelId}/bookings/all`

### Rating Service Routes
- Fetch all ratings: `http://localhost:8086/ratings/all`
- Add a rating: `http://localhost:8086/ratings/add`
- Fetch ratings by user ID: `http://localhost:8086/ratings/user/{userId}`
- Fetch ratings by hotel ID: `http://localhost:8086/ratings/hotel/{hotelId}`

## Contributing
Contributions are welcome. Please create an issue or pull request if you'd like to contribute to this project.

## License
This project is licensed under the [MIT License](LICENSE).
