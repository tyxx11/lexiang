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

create table product_detail(
  id int primary key auto_increment,
  product_id int,
  team_member_upper_limit int,
  sign_up_people varchar(10) comment '报名对象',
  gathering_place varchar(64),
  disbanded_place varchar(64),
  trival_topo_id int,
  div_baomingwuyou text,
  div_tiyanwuyou text,
  div_jiagewuyou text,
  div_changjianwenti text,
  div__xingchengliangdian text,
  div_quxiaodingdan text,
  div_shuoming text,
  read_before_travel_id
)DEFAULT CHARSET=utf8;

create table trival_topo(
  id int primary key auto_increment,
  name varchar(),
  trival_date varchar,
  photo varchar,
  ruzhu varchar,
  food varchar,
  checheng varchar,
  div1,
  div2,
  div3
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
  tag_id int
)DEFAULT CHARSET=utf8;

create table price_not_contain(
  id int primary key auto_increment,
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
  tag_id int
)DEFAULT CHARSET=utf8;

create table read_before_travel_tag(
  id int primary key auto_increment,
  tag_name varchar(10),
  tag_describe text,
)DEFAULT CHARSET=utf8;

create table custom_story(
  id int primary key auto_increment,
  pic1 varchar,
  div1 text,
  pic2 varchar,
  div2 text,
  pic3 varchar,
  div3 text,
  pic4 varchar,
  div4 text
)DEFAULT CHARSET=utf8;