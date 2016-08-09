drop database wmm;
create database wmm;
use wmm;

CREATE TABLE user(
id varchar(10),
password varchar(100),
PRIMARY KEY(id)
);

CREATE TABLE tr_group(
id int AUTO_INCREMENT,
name varchar(10),
admin_id varchar(10),
open varchar(1),

PRIMARY KEY(id),
FOREIGN KEY(admin_id) REFERENCES user(id)
);

CREATE TABLE  user_group(
id int AUTO_INCREMENT,
group_id int,
user_id varchar(10),
accepted varchar(1),

PRIMARY KEY(id),
FOREIGN KEY(group_id) REFERENCES tr_group(id),
FOREIGN KEY(user_id) REFERENCES user(id)
);

