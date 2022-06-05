CREATE DATABASE IF NOT EXISTS quanlyhanghoa;
USE quanlyhanghoa;
DROP TABLE IF EXISTS thucpham;
CREATE TABLE thucpham(
                         id int,
                         name varchar(50),
                         price float,
                         qty int,
                         PRIMARY KEY (id));

INSERT INTO thucpham VALUES (001,'Banh gao',20,10);
INSERT INTO thucpham VALUES (002,'Sua tuoi',50,40);
INSERT INTO thucpham VALUES (003,'Mi tom',5,100);
INSERT INTO thucpham VALUES (003,'Nuoc loc',10,50);
INSERT INTO thucpham VALUES (005,'Bim bim',10,100);
