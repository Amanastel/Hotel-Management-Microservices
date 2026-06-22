## Hotel Management Microservices – AGENTS.md

This repo is a **Java Spring Boot microservices system**. Multiple services must be run together for full functionality. Agents should avoid assuming a simple single-app setup.

### Structure & Boundaries
- Each service is a separate Maven project with its own `pom.xml` and `src/` directory.
  - Key services: `User`, `hotelServices`, `ratingServices`, `department-service`, `config-server`, `api-gateway`, `service-registry` (Eureka).
- The API Gateway (port `8086`) fronts all user-facing endpoints; Eureka service registry (port `8761`) tracks service status.
- Services depend on Spring Cloud Config (config-server) for properties – **configuration changes in config-server affect all services**.

### Running the System
1. **Build** all services: run `mvn clean install` at the root or individually in each service directory.
2. **Startup order matters**:
   - Start `service-registry` (Eureka) first.
   - Start `config-server`.
   - Then start other microservices (`User`, `hotelServices`, `ratingServices`, etc.).
   - Start `api-gateway` last.
3. Verify service registration in Eureka dashboard at `http://localhost:8761`.

### Local Usage
- All external requests should be sent via API Gateway URLs (see `README.md` for endpoint list).
- Auth: Login via `/auth/login` or `/users/login` to get an access token, required for authenticated API calls.
- DB: Services use MySQL, MongoDB – ensure both are running locally with configured credentials.
- Okta integration: OAuth 2.0 – requires correct Okta issuer and client ID in configs.

### Testing
- Tests are minimal and primarily check Spring context loading.
- Run tests for a single service: `mvn test` in that service directory.
- No central integration test harness – verifying inter-service flow requires running real services.

### Agent Workflow Tips
- Always inspect the `application.properties` or `application.yml` of each microservice before changes; config often duplicated or overridden.
- Do not assume port numbers – they are set per-service in configs.
- Endpoints in `README.md` are hardcoded for localhost; adjust when running in other environments.
- Avoid editing generated or vendor configs unless explicitly adjusting build/runtime wiring.

### References
- Main setup & endpoint list: [`README.md`](README.md)
- Maven build & dependencies: individual `pom.xml` files.
