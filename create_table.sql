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

drop table if exists product_detail;
create table product_detail(
  id int primary key auto_increment,
  product_id int,
  team_member_upper_limit int,
  sign_up_people varchar(10) comment '报名对象',
  gathering_place varchar(64),
  disbanded_place varchar(64),
  div_baomingwuyou text,
  div_tiyanwuyou text,
  div_jiagewuyou text,
  div_common_problems text,
  div__travel_characteristic text,
  div_cancel_order text,
  div_explain text comment '说明'
)DEFAULT CHARSET=utf8;

drop table if exists travel_topo;
create table travel_topo(
  id int primary key auto_increment,
  product_id int,
  name varchar(128),
  travel_date varchar(24),
  photo_address varchar(128),
  accommodation varchar(64),
  food varchar(64),
  range_of_driving varchar(32),
  div1 text comment 'describe 1',
  div2 text comment 'describe 2',
  div3 text comment 'describe 3'
)DEFAULT CHARSET=utf8;

create table product_comments (
  id int primary key auto_increment,
  name varchar(64),
  coments_conntent varchar(255),
  profile_photo varchar(128),
  product_id int
)DEFAULT CHARSET=utf8;

create table price_contain(
  id int primary key auto_increment,
  product_id int,
  tag_id int
)DEFAULT CHARSET=utf8;

create table price_not_contain(
  id int primary key auto_increment,
  product_id int,
  tag_id int
)DEFAULT CHARSET=utf8;

create table price_tag(
  id int primary key auto_increment,
  tag_name varchar(10),
  tag_describe varchar(255),
  tag_photo varchar(128)
)DEFAULT CHARSET=utf8;

create table read_before_travel(
  id int primary key auto_increment,
  tag_id int,
  product_id int
)DEFAULT CHARSET=utf8;

create table read_before_travel_tag(
  id int primary key auto_increment,
  tag_name varchar(24),
  tag_describe text
)DEFAULT CHARSET=utf8;

create table customer_story(
  id int primary key auto_increment,
  pic_address varchar(128),
  div_customer text,
  time_stamp timestamp,
  status int
)DEFAULT CHARSET=utf8;