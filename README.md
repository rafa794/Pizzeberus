# Proyecto Spring Cloud de Pizzeberus
Proyecto con Sleuth y Zipkin implementado. (Sin cumplir todos los RF)

# Guía de uso
1.``mvn clean install`` para instalar las dependencias del proyecto.
2.``docker-compose up --build`` para levantar Rabbitmq, Zipkin y Postgres.
3. Arrancar desde el IDE el servicio Config Server.
4. Arrancar desde el IDE el servicio Eureka Server.
5. Arrancar desde el IDE el servicio Gateway Server.
6. Arrancar desde el IDE los servicios pizza-read, pizza-write, user-crud.


# Documentación
- Config server: http://localhost:8888/<nombre_servicio>/default
- Eureka server: http://localhost:8761/
- Gateway: http://localhost:9000/
- pizza-read: http://localhost:8081/swagger-ui.html (sin implementar)
- pizza-write: http://localhost:8082/swagger-ui.html (sin implementar)
- user-crud: http://localhost:8082/swagger-ui.html (sin implementar)

# Autor
Rafael Mendoza Márquez# Pizzeberus
# Pizzeberus
