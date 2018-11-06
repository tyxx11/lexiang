drop table if exists lexiang_product;
create table lexiang_product(
  id int primary key auto_increment,
  title varchar(1024),
  photo_path varchar(64),
  intro text,
  createdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modifydate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  target_address varchar(64),
  days int,
  price int,
  status int,
  traval_type int
) DEFAULT CHARSET=utf8;

create table trval_type(
  id int primary key auto_increment,
  type_name varchar(64)
) DEFAULT CHARSET=utf8;


create table photos(
  id int primary key auto_increment,
  name varchar(64),
  status int,
  path varchar(256),
  attribute int,
  description varchar(128)
) DEFAULT CHARSET=utf8;

create table static_pages(
  id int primary key auto_increment,
  about_us_page varchar(21845),
  home_page varchar(21845),
  time_stamp timestamp,
  status int
) DEFAULT CHARSET=utf8;

create table home_page_content(
  id int primary key auto_increment,
  div_top text(21845),
  div_mid text(21845),
  div_bot text(21845),
  time_stamp timestamp,
  status int
) DEFAULT CHARSET=utf8;

create table system_setting(
  id int primary key auto_increment,
  log1 varchar(128),
  log2 varchar(128),
  tel_num varchar(64),
  address varchar(128),
  company_name varchar(128),
  time_stamp timestamp
) DEFAULT CHARSET=utf8;

create table navigator(
  id int primary key auto_increment,
  name varchar(64),
  parent_name varchar(64),
  attribute int,
  time_stamp timestamp,
  status int
) DEFAULT CHARSET=utf8;

create table lunbo(
  id int primary key auto_increment,
  photo_address varchar(128),
  attribute int,
  time_stamp timestamp,
  status int
) DEFAULT CHARSET=utf8;