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

CREATE TABLE IF NOT EXISTS 'users'(
    username VARCHAR(50) PRIMARY KEY NOT NULL,
    firstName Varchar(150) NOT NULL,
    lastName Varchar(150) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    role VARCHAR(50) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS 'order'(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    orderNo VARCHAR(100) NOT NULL UNIQUE,
    owner VARCHAR(150) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP,
    total REAL
);

CREATE TABLE IF NOT EXISTS 'order_items'(
    orderNo VARCHAR(100),
    product_id INTEGER,
    quantity INTEGER NOT NULL CHECK(quantity > 0),
    PRIMARY KEY(orderNo, product_id),
    FOREIGN KEY(orderNo) REFERENCES "orders"(orderNo) ON DELETE CASCADE,
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE
);

INSERT INTO "orders" (orderNo, owner, total, created)
VALUES ('ORD000', 'John Doe', 300.00, datetime('now'));

INSERT INTO order_items (orderNo, product_id, quantity)
VALUES ('ORD000' ,1, 2);


SELECT * 
FROM orders o
JOIN order_items ON o.orderNo = order_items.orderNo
WHERE o.orderNo="ORD000";

ALTER TABLE "order" RENAME TO orders;

SELECT 
        o.orderNo, o.owner, o.total, o.created,
        oi.product_id, oi.quantity
        FROM orders o 
        JOIN order_items oi ON o.orderNo = oi.orderNo
        JOIN product p ON oi.product_id = p.id
        WHERE o.orderNo = "ORD000";
