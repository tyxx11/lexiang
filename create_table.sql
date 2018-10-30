create table lexiang_product(
  id int primary key auto_increment,
  title varchar(1024),
  intro varchar(21845),
  createdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modifydate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  address varchar(64),
  days int,
  price int,
  status int
);

create table photos(
  id int primary key auto_increment,
  name varchar(64),
  status int,
  path varchar(256),
  attribute int,
  description varchar(128)
);