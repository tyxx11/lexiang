create table lexiang_product(
  id int primary key auto_increment,
  title varchar(1024),
  intro varchar(64512),
  createdate timestamp,
  modifydate timestamp,
  address varchar(64),
  days int,
  price int,
  status int
);