# Mareo-Envios

## Intro:

Este proyecto fue realizado para un challenge técnico.
Cumplir con los siguientes requerimientos:
* Poder obtener información del comprador.
* Poder obtener información del envío y productos comprados.
* Poder cambiar el estado del envío siguiendo las siguientes reglas de negocio:
    * El estado inicial es “Inicial” y solo se puede transicionar a “Entregado al correo” y a “Cancelado”
    * El estado “Entregado al correo” solo se puede transicionar a “En camino” y a “Cancelado”
    * El estado “En camino” solo se puede transicionar a “Entregado”
    * Los estados “Entregado” y “Cancelado” son estados finales y no se pueden transicionar.
* Obtener un listado con la descripción y cantidad de los 3 productos más solicitados para su envío, aunque el pedido este cancelado.

## Instalación:

- Realizar la instalación maven con el siguiente comando: mvn clean install
- Ejecutar con el siguiente comando: mvn clean spring-boot:run
- La aplicación está construida con JPA Repository por lo que las tablas y relaciones se crean automáticamente
- También se creó el archivo: [mareo-envios-db](https://github.com/paaherre/mareo-envios/blob/master/src/main/resources/db/mareo-envios-db.sql) donde se encuentra información para crear la base, con sus tablas y relaciones, también se agregaron casos de ejemplo para el consumo de la API  

## Modo de uso:

- Con la aplicación y la base corriendo puede utilizar postman para realizar las consultas de los requerimientos:

- Se creó el siguiente workspace en postman para el consumo de la API: [Postman-Mareo-envios](https://www.postman.com/gold-star-520402/workspace/mareo-envios)

###1. Obtener información del comprador:

![getCustomer](https://github.com/paaherre/mareo-envios/blob/master/src/main/resources/screenshots/getCustomer.png?raw=true)

###2. Obtener información del envío y productos comprados:

![getShipping](https://github.com/paaherre/mareo-envios/blob/master/src/main/resources/screenshots/getShipping.png?raw=true)

###3. Realizar cambio de estados:

![patchShipping](https://github.com/paaherre/mareo-envios/blob/master/src/main/resources/screenshots/patchShipping.png?raw=true)

En el caso de no poder realizar la transición de un estado a otro enviará un mensaje de error personalizado indicando el estado actual.

###4. Obtener reporte de envíos:

![getReport](https://github.com/paaherre/mareo-envios/blob/master/src/main/resources/screenshots/getReport.png?raw=true)

## Tecnologías:

- RESTFull Json
- Springboot v2.7.8
- Java 8
- Maven
- JPA
- Hibernate
- MySQL