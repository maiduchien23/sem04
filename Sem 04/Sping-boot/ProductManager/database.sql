CREATE DATABASE productmanagement

CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_name varchar(255) NOT NULL,
  brand varchar(100) NOT NULL,
  price double(12,2) NOT NULL,
  description varchar(255) NOT NULL,
  quantity int(10) NOT NULL,
  PRIMARY KEY (id)
)


    INSERT INTO product (id, product_name, brand, price, description, quantity) VALUES
(1, 'iPhone 12', 'Apple', 799.00, '6.1-inch Super Retina XDR display, A14 Bionic chip', 50),
(2, 'Samsung Galaxy S21', 'Samsung', 799.00, '6.2-inch Dynamic AMOLED 2X display, Snapdragon 888', 250),
(3, 'Google Pixel 5', 'Google', 699.00, '6.0-inch OLED display, Snapdragon 765G, 5G', 150),
(4, 'OnePlus 9 Pro', 'OnePlus', 969.00, '6.7-inch Fluid AMOLED display, Snapdragon 888, 5G', 100),
(5, 'Sony Xperia 1 III', 'Sony', 1299.00, '6.5-inch 4K HDR OLED display, Snapdragon 888, 5G', 250),
(6, 'Iphone 13 Pro', 'Apple', 999.00, '6.1-inch Super Retina XDR OLED display, Apple A15 Bionic', 500);