# Challenge Store #

## What is this? ##
This is a java project to improve knowledge about Spring Cloud, microservices architecture and clean code.

## Prerequesite ##
- Docker
- JDK 8+
- Your favorite IDE

### Run PostgreSQL Container ###
```
docker run --name challenge-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d -v /opt/postgres/data:/var/lib/postgresql/data postgres

docker exec -it challenge-postgres psql -U postgres
create database store_db;
create database order_db;
```