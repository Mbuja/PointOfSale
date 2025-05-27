CREATE TABLE IF NOT EXISTS 'company'(
    name VARCHAR(150) PRIMARY KEY NOT NULL,
    email VARCHAR(150) UNIQUE,
    address varchar(150),
    telephone varchar(25) NOT NULL,
    accountNumber varchar(30) NOT NULL,
    description varchar(250) ,

);

CREATE TABLE IF NOT EXISTS 'product'(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(150),
    company VARCHAR(150),
    price REAL NOT NULL,
    product_no VARCHAR(100),
    serial_no VARCHAR(50),
    description VARCHAR(250),
    FOREIGN KEY(company) REFERENCES company(name) ON DELETE CASCADE
   
);

