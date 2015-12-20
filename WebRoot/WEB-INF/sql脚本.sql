create table t_user(
	user_id	int auto_increment primary key,
	user_name	varchar(30),
	credits int,
	password varchar(32),
	last_visit datetime,
	last_ip varchar(23)
)engine=innodb;test

create table t_login_log(
	login_log_id int auto_increment primary key,
	user_id int,
	ip varchar(23),
	login_datetime datetime
)engine=innodb;

insert into t_user(user_name,password) values('admin','123456');