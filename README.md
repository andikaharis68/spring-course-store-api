# COURSE-STORE-API

This is a simple API for recording managing customer account using Springboot Jdbc template and JPA. 

Features :

- CRUD
- JWT Authentication
- Input Validation
- Native Query (JDBC Template)
- JPA

## How to Install

1. Clone this repository.

```bash
git clone https://github.com/andikaharis68/spring-course-store-api.git
```

2. Import database/db_account_system.sql file to the MySQL database server.

3. Configure application.yml file at src/main/resources directory or you can configure these environment variables :

| Name       | Description       | Default       |
| ---------- | ----------------- | ------------- |
| PORT       | Server Port       | 8080          |
| API_KEY    | JWT Secret Key    | javainuse     |
| DB_HOST    | Database Host     | localhost     |
| DB_PORT    | Database Port     | 3306          |
| DB_NAME    | Database Name     | course_api    |
| DB_USER    | Database User     | root          |
| DB_PASS    | Database Password | root123       |
| swagger-ui | swagger-ui path   | /swagger.html |


4. Run the application (development).

```bash
mvnw spring-boot:run
```

## How to build and run Docker

Note: for testing purposes.

```bash
docker-compose up -d --build
```

