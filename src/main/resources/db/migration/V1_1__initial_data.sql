INSERT INTO categories (`name`) VALUES ("Power Tools");
INSERT INTO categories (`name`) VALUES ("Plumbing");
INSERT INTO categories (`name`) VALUES ("Paint");
INSERT INTO categories (`name`) VALUES ("Lumber & Building Materals");
INSERT INTO categories (`name`) VALUES ("Hand Tools");

INSERT INTO manufacturers (`name`) VALUES ("Bosch");
INSERT INTO manufacturers (`name`) VALUES ("MGF");
INSERT INTO manufacturers (`name`) VALUES ("Boysen");
INSERT INTO manufacturers (`name`) VALUES ("Filtra Timber");
INSERT INTO manufacturers (`name`) VALUES ("Butterfly");

INSERT INTO inventories (`name`, stock, price, category_id, manufacturer_id) 
 VALUES ('Drill', 100, 3000, 1, 1);
INSERT INTO inventories (`name`, stock, price, category_id, manufacturer_id)
 VALUES ('Pipe', 99, 1500, 2, 2);
INSERT INTO inventories (`name`, stock, price, category_id, manufacturer_id)
 VALUES ('Lime green coating paint', 115, 1000, 3, 3);
INSERT INTO inventories (`name`, stock, price, category_id, manufacturer_id)
 VALUES ('Plywood', 100, 500, 4, 4);
 INSERT INTO inventories (`name`, stock, price, category_id, manufacturer_id)
 VALUES ('Hammer', 149, 1300, 5, 5);

INSERT INTO orders (ordered_at, quantity, amount)
 VALUES ('2023-05-15 14:24:37', 1, 1500);
INSERT INTO orders (ordered_at, quantity, amount)
 VALUES ('2023-05-15 14:25:30', 5, 5000);
INSERT INTO orders (ordered_at, quantity, amount)
 VALUES ('2023-05-15 14:28:01', 1, 1300);
