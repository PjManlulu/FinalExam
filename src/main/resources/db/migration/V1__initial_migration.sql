CREATE TABLE categories (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL
);

CREATE TABLE manufacturers (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL
);

CREATE TABLE inventories (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    stock int NOT NULL,
    price int NOT NULL,
    category_id int NOT NULL,
    manufacturer_id int NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id)
);

CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ordered_at TIMESTAMP NOT NULL,
    quantity int NOT NULL,
    amount int NOT NULL
);
