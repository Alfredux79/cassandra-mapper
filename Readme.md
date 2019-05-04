# Cassandra Mapper Demo Project

This projects demonstrates a very simple use case of the [object mapper](https://docs.datastax.com/en/developer/java-driver/3.4/manual/object_mapper/) included in the cassandra driver.

Requirements:

- Java 8
- Maven 3.5
- Docker
- Docker Compose 

## Useful commands to play with the project:

- To start the cassandra server and create the schema:
`docker-compose up`

- To run the test scenarios from the command line:
`mvn clean test`
