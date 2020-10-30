/* Populate tables*/
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (1,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (2,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (3,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (4,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (5,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (6,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (7,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (8,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (9,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (10,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (11,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (12,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (13,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (14,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (15,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (16,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (17,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (18,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (19,'Patricia','Sanchez','patricia@hotmail.com','2020-10-20','');
INSERT INTO clientes(id,nombre,apellido,email,create_at,foto) VALUES (20,'Julio','Lopez','julio@hotmail.com','2020-10-20','');
/*Populate tabla productos*/
INSERT INTO productos(nombre, precio, create_at) VALUES ('Panasonic pantalla LCD',259990,NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony camara Digital DSC-W320B',123490,NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple Ipod shuffle',1499990,NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony Notebook Z110',37990,NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Bianchi vicicleta Aro 26',69990,NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Mica comoda 5 cajones',299990,NOW());

/*Creamos unas facturas*/
INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipo de oficina',null,1,NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (2, 1, 4);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 5);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 6);
INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura vicicleta','Alguna nota importante!',1,NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (3, 2, 6);
