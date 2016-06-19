use wmm;

CREATE TABLE user(
username varchar(10),
password varchar(50),
PRIMARY KEY(username)
);

CREATE TABLE tr_group(
id long,
name varchar(10),
admin varchar(10)

REFERENCES user (admin)
);
