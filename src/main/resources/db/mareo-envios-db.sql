create table mareo_envios;
use mareo_envios;

CREATE TABLE customer (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE shipping (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer_id BIGINT NOT NULL,
  state ENUM('PENDING', 'SENT', 'DELIVERED') NOT NULL,
  send_date DATE NOT NULL,
  arrive_date DATE,
  priority INT,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE shipping_item (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  shipping_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  product_count INT NOT NULL,
  FOREIGN KEY (shipping_id) REFERENCES shipping(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE product (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  weight double NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO customer (first_name, last_name, address, city)
VALUES
('John', 'Doe', '123 Main St', 'New York'),
('Jane', 'Smith', '456 Oak Ave', 'Los Angeles'),
('Bob', 'Johnson', '789 Pine Rd', 'Chicago'),
('Alice', 'Brown', '246 Maple St', 'Houston'),
('Michael', 'Davis', '135 Cedar Blvd', 'Philadelphia'),
('Emily', 'Wilson', '678 Elm St', 'Phoenix'),
('William', 'Anderson', '159 Oak St', 'San Antonio'),
('Sophia', 'Thomas', '753 Maple Ave', 'San Diego'),
('Olivia', 'Jackson', '369 Pine St', 'Dallas'),
('Ava', 'White', '159 Cedar Rd', 'San Francisco');

INSERT INTO product (description, weight)
VALUES
('Teclado', 0.75),
('Mouse', 0.30),
('Altavoces', 1.50),
('Pantalla', 4.50),
('Impresora', 6.50),
('Escáner', 3.75),
('Disco Duro Externo', 0.80),
('Unidad óptica', 0.70),
('Webcam', 0.50),
('Adaptador de corriente', 0.35),
('Cables HDMI', 0.15),
('Cables USB', 0.10),
('Tarjeta gráfica', 1.20),
('Tarjeta de sonido', 0.75),
('Fuente de poder', 1.00),
('Gabinete', 3.00),
('Ventilador', 0.50),
('Placa base', 1.50),
('Memoria RAM', 0.20),
('Procesador', 0.75);

INSERT INTO shipping (customer_id, state, send_date, arrive_date, priority)
VALUES
(2, 'initial', '2022-01-01', NULL, 1),
(3, 'sendToMail', '2022-01-03', '2022-01-07', 2),
(1, 'inTravel', '2022-01-05', '2022-01-10', 3),
(10, 'delivered', '2022-01-08', '2022-01-13', 1),
(6, 'cancelled', '2022-01-10', NULL, 2),
(4, 'initial', '2022-01-12', NULL, 3),
(8, 'sendToMail', '2022-01-15', '2022-01-20', 1),
(7, 'inTravel', '2022-01-18', '2022-01-23', 2),
(9, 'delivered', '2022-01-20', '2022-01-25', 3),
(1, 'cancelled', '2022-01-22', NULL, 1),
(5, 'initial', '2022-01-01', NULL, 1),
(6, 'sendToMail', '2022-01-03', '2022-01-07', 2),
(2, 'inTravel', '2022-01-05', '2022-01-10', 3),
(7, 'delivered', '2022-01-08', '2022-01-13', 1),
(1, 'cancelled', '2022-01-10', NULL, 2),
(3, 'initial', '2022-01-12', NULL, 3),
(4, 'sendToMail', '2022-01-15', '2022-01-20', 1),
(5, 'inTravel', '2022-01-18', '2022-01-23', 2),
(10, 'delivered', '2022-01-20', '2022-01-25', 3),
(9, 'cancelled', '2022-01-22', NULL, 1);

INSERT INTO shipping_item (shipping_id, product_id, product_count)
VALUES
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1)),
  (ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1), ROUND(RAND() * 19 + 1));