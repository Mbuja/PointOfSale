CREATE TABLE IF NOT EXISTS 'company'(
    name VARCHAR(150) PRIMARY KEY NOT NULL,
    email VARCHAR(150) UNIQUE,
    address varchar(150),
    telephone varchar(25) NOT NULL,
    accountNumber varchar(30) NOT NULL,
    description varchar(80) ,

);

CREATE TABLE IF NOT EXISTS 'product'(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(150),
    company VARCHAR(150),
    FOREIGN KEY(company) REFERENCES company(name) ON DELETE CASCADE,
    price DOUBLE NOT NULL,
    barcode VARCHAR(100)
);

