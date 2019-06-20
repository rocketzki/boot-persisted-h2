DROP TABLE IF EXISTS laptops;
CREATE TABLE laptops
(
    id                     INT AUTO_INCREMENT PRIMARY KEY,
    producer               VARCHAR(55) NOT NULL,
    model                  VARCHAR(55) NOT NULL,
    price                  DECIMAL(10) NOT NULL,
    processor_manufacturer VARCHAR(20) DEFAULT NULL
);

INSERT INTO laptops (producer, model, price, processor_manufacturer)
VALUES ('MSI', 'GE61', 2000, 'Intel'),
       ('Lenovo', 'G5', 1000, 'AMD'),
       ('Apple', 'MacBook Pro 13', 11000, 'Intel'),
       ('Toshiba', '400P', 6000, 'ARM');



DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(55)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);

INSERT INTO users (username, password, enabled)
VALUES ('mary', '$2a$10$6n5MSOo87/wZ7tdXgi6tq.UUsQFMAu56DbpARHfnFtGMiHhjeDgFq', true),   -- password
       ('vinesh', '$2a$10$nT76r851fofA55wJO6QA1OJM7wZmnUVUfvv15FoRl1keZ77EkEYBO', true), -- pass
       ('thanos', '$2a$10$AW5G1nlMzXAXNsxXYDbdgO02vSRxgzcoGa54kImLH5c7KDV1XlaaO', true); -- pass2


DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(55)  NOT NULL,
    authority VARCHAR(55) NOT NULL
);
INSERT INTO authorities (username, authority)
VALUES ('mary', 'ADMIN'),
       ('vinesh', 'SUPERUSER'),
       ('thanos', 'USER');
