cd# EagleEYE MSP Service

The EagleEye MSP service is a RESTful api that handles the connection point between the database and the UI client.
This service does have a local in memory h2 database.

## Running locally
In order to run locally, you will need ``mvn`` command installed locally.

```
mvn clean install
mvn spring-boot:run -Dspring.profiles.active=local
```