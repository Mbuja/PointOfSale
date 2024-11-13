CREATE TABLE IF NOT EXISTS 'company'(
    name VARCHAR(150) PRIMARY KEY NOT NULL,
    email VARCHAR(150) UNIQUE,
    address varchar(150),
    telephone varchar(25) NOT NULL,
);