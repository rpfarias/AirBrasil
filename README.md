# Air Brasil Application

Application for searching, buying and booking tickets.

### Dependencies

- [Java 11 Development Kit](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [MySQL](https://www.mysql.com/)

### Built With

- [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Springboot](https://spring.io/projects/spring-boot/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa/)
- [Maven](https://maven.apache.org/)
- [Swagger](https://swagger.io/)
- [MapStruct](https://mapstruct.org/)
- [Lombok](https://projectlombok.org/)
- [Security](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core)

### Getting Started

The application can be started using Maven.

> `Acesse o arquivo application.properties e altere os dados de acesso ao banco de dados, como no exemplo abaixo`
>

```
spring.datasource.url=jdbc:mysql://localhost:3306/airbrasil
spring.datasource.username=root
spring.datasource.password=root
```

> `mvn clean install`
>
> `mvn spring-boot:run`

### Facilities

- Port - http://localhost:8080/
- Swagger - http://localhost:8080/swagger-ui/index.html

### Antes de dar POST nos Tickets, dê um Get all em Routes e verifique as rotas disponíveis!

- GET
- http://localhost:8080/api/routes

### Siga os Passos:

- POST User
- http://localhost:8080/api/users
### Grave o ID do seu usuário, vai precisar quando for reservar um Ticket.
```
{
  "username": "maria@gmail.com",
  "password": "12345",
  "name": "Maria Gomes",
  "cpf": "25870911010"
}
```
- GET All Routes
- http://localhost:8080/api/routes


- POST Tickets
- http://localhost:8080/api/tickets
```
{
  "passager": "Rodrigo Santos",
  "cpf": "08736031097",
  "origin": "Salvador",
  "destiny": "São Paulo",
  "dataIda": "29/04/2022",
  "dataVolta": "25/05/2022",
  "userId": 1
}
```
- GET by Passager
- http://localhost:8080/api/tickets/passager/Rodrigo Santos
