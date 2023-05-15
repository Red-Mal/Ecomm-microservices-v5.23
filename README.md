# Ecomm-microservices-v5.23

# Ecommerce Microservices Project

This repository contains a collection of microservices for an ecommerce application, including a discovery server, inventory service, order service, product service, and API gateway.

## Table of Contents
- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Overview
The ecommerce microservices project aims to provide a scalable and modular architecture for managing various aspects of an ecommerce system. The different microservices included in this project are:

- **Discovery Server**: This service acts as a registry for all the microservices in the system. It enables service discovery and allows other services to locate and communicate with each other.

- **API Gateway**: The API gateway serves as the entry point for external clients to access the ecommerce system. It routes incoming requests to the appropriate microservices, handles authentication, and performs load balancing.

- **Inventory Service**: The inventory service manages the inventory of products in the ecommerce system. It provides functionality to add, update, and retrieve inventory information for different products.

- **Order Service**: The order service handles the creation and management of orders placed by customers. It integrates with other services to ensure accurate inventory management and order fulfillment.

- **Product Service**: The product service is responsible for managing the product catalog. It provides APIs to retrieve product information, add new products, and update existing products.


## Technologies Used
The ecommerce microservices project utilizes the following technologies and frameworks:

- Spring Boot: Java-based framework for building microservices.
- Spring Cloud: Provides tools and libraries for building cloud-native microservices.
- Eureka Server: Service registry and discovery server for locating microservices.
- API Gateway: Handles routing, authentication, and load balancing for external requests.
- Maven: Build and dependency management tool.
- Git: Version control system.
- Resilience4j : is a lightweight fault tolerance library that provides a variety of fault tolerance and stability patterns to a web application(Circuit Breaker, Rate Limiter, Retry or Bulkhead).
- Micrometer : provides a simple facade for the most popular tracer libraries (Distributed Tracing).

## Installation
To install and set up the ecommerce microservices project, follow these steps:

1. Clone the repository:

  ```bash
  git clone https://github.com/Red-Mal/Ecomm-microservices-v5.23.git
  ```
2. Change to the project directory:

  ```bash
  cd Ecomm-microservices-v5.23
  ```
3. Build the microservices using Maven:

  ```bash
  mvn clean install
  ```
 4. Start the microservices in the following order:

- Start the discovery server (Eureka Server).
- Start the inventory service, order service, product service, and API gateway.


## Usage
Once the microservices are up and running, you can start using the ecommerce system. Here are some examples of how to interact with the services:

- Use the API gateway endpoint to access various functionalities of the ecommerce system.
- Make requests to the inventory service API to manage product inventory.
- Place orders using the order service API.
- Retrieve product information using the product service API.


## Features
The ecommerce microservices project offers the following features:

- Service discovery and registration with the Eureka Server.
- Inventory management for products.
- Order creation and management.
- Product catalog management.
- Centralized API gateway for external client access.

## Contributing
If you would like to contribute to this project and make it better, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or improvement.
3. Make your changes and commit them.
4. Push to your forked repository.
5. Submit a pull request detailing your changes.

