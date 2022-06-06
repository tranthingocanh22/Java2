CREATE DATABASE IF NOT EXISTS Manage;
USE Manage ;
DROP TABLE IF EXISTS Movies1;
CREATE TABLE Movies1(
                        id varchar(10),
                        name varchar(50),
                        premiere_time varchar(30),
                        Author_name varchar(50),
                        time int,
                        PRIMARY KEY (id));
INSERT INTO Movies1 VALUES('MP01', 'Phim ma', '7/6/2022', 'Nguyen A', 180);
INSERT INTO Movies1 VALUES('MP02', 'Phim hoat hinh', '8/6/2022', 'Nguyen B', 120);
INSERT INTO Movies1 VALUES('MP03', 'Phim Viet Nam', '9/6/2022', 'Nguyen C', 90);
INSERT INTO Movies1 VALUES('MP04', 'Phim Trung Quoc', '10/6/2022', 'Nguyen D', 150);

