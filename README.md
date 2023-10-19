# Proyecto Kafka
Proyecto Kafka con bases de datos H2, microservicios PCS, MIXBI, AGR.
# Guía de uso
2. ``mvn clean install`` para instalar las dependencias del proyecto.
3. ``docker-compose up --build`` para levantar Kafka, Redpanda, Schema Registry, Zookeeper y Sonar.
4. Arrancar desde el IDE el servicio api-restaurante para la creación/eliminación de restaurantes.
5. Arrancar desde el IDE el servicio api-opiniones para el crud de opiniones.
6. Arrancar desde el IDE el servicio pcs para mapear las fechas a un formato más amigable.
7. Arrancar desde el IDE el servicio mixbi para unir restaurantes y opiniones.
8. Arrancar desde el IDE el servicio agr para agregar el campo calificacion promedio a nuestro mensaje y exponer endpoint de consulta.

![Esquema](./images/Diagramas%20de%20flujo.jpeg)

# Documentación
- BD opiniones: http://localhost:8082/h2-console
- BD restaurantes:http://localhost:8083/h2-console
- BD Opiniones-Restaurante: http://localhost:8086/h2-console
- Redpanda: http://localhost:8080/overview
- Sonar dashboard: http://localhost:9000/ 

# Autor
- Rafael Mendoza Márquez