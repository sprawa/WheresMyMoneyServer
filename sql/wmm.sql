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
name varchar(30),
open varchar(1),

PRIMARY KEY(id)
);

CREATE TABLE  group_user(
id int AUTO_INCREMENT,
group_id int,
user_id varchar(10),
admin varchar(1),
exited varchar(1),

PRIMARY KEY(id),
FOREIGN KEY(group_id) REFERENCES tr_group(id) ON DELETE CASCADE,
FOREIGN KEY(user_id) REFERENCES user(id)
);

CREATE TABLE transaction(
id int AUTO_INCREMENT,
group_id int,
description varchar(50),
lender varchar(10),
borrower varchar(10),
value numeric(7,2),

PRIMARY KEY(id),
FOREIGN KEY(group_id) REFERENCES tr_group(id) ON DELETE CASCADE,
FOREIGN KEY(lender) REFERENCES user(id),
FOREIGN KEY(borrower) REFERENCES user(id)
);