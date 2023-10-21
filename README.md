# Hotel-Management-Microservices Project


This project is a collection of Spring Boot-based microservices that provide various services for a hotel management system. The project includes the following microservices:

- [User Service](#user-service)
- [Service Registry](#service-registry)
- [Hotel Service](#hotel-service)
- [Rating Service](#rating-service)
- [Config Service](#config-service)
- [API Gateway](#api-gateway)

## User Service

The User Service is responsible for managing user-related functionalities. It uses Spring Boot and includes the following key dependencies:

- Spring Boot Actuator
- Spring Boot AOP
- Resilience4j for resilience and fault tolerance
- Spring Cloud Eureka Client for service registration
- Spring Cloud Config for configuration management
- Spring Cloud OpenFeign for REST API integration
- Spring Data JPA for data access
- Spring Web for web services
- Springdoc for API documentation
- MySQL Connector for database access
- Lombok for reduced boilerplate code

## Service Registry

The Service Registry is a Eureka server for service registration and discovery. It uses Spring Boot and includes the following key dependency:

- Spring Cloud Eureka Server

## Hotel Service

The Hotel Service is responsible for managing hotel-related data. It uses Spring Boot and includes the following key dependencies:

- Spring Boot Actuator
- Spring Cloud Eureka Client for service registration
- Spring Boot Data JPA for data access
- Spring Boot Web for web services
- Spring Boot Validation for input validation
- Springdoc for API documentation
- PostgreSQL Connector for database access
- Lombok for reduced boilerplate code

## Rating Service

The Rating Service handles the rating of hotels. It uses Spring Boot and includes the following key dependencies:

- Spring Boot Actuator
- Spring Cloud Eureka Client for service registration
- Spring Boot Data JPA for data access
- Spring Boot Web for web services
- Spring Boot Validation for input validation
- Springdoc for API documentation
- MySQL Connector for database access
- Lombok for reduced boilerplate code

## Config Service

The Config Service is responsible for providing centralized configuration management. It uses Spring Boot and includes the following key dependency:

- Spring Cloud Config Server
- Spring Cloud Eureka Client for service registration

## API Gateway

The API Gateway acts as a gateway for routing and securing requests to the microservices. It uses Spring Boot and includes the following key dependencies:

- Spring Boot WebFlux for reactive web services
- Spring Cloud Gateway for routing and load balancing
- Spring Cloud Eureka Client for service registration
- Spring Security for security
- Okta Spring Boot Starter for Okta integration

## Getting Started

To run the microservices, follow these steps:

1. Clone the repository.
2. Build each microservice using Maven or your preferred build tool.
3. Start the Service Registry, Config Service, and API Gateway.
4. Start the User Service, Hotel Service, and Rating Service.
5. Access the services through the API Gateway.
6. Explore the API documentation provided by Springdoc.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
