-- Users / Roles
insert into user(id, name, login, password) values (1,'user','user','user');
insert into user(id, name, login, password) values (2,'admin','admin','admin');
insert into user(id, name, login, password) values (3,'guest','guest','guest');

insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');
insert into role(id, name) values (3,'ROLE_GUEST');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);
