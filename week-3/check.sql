drop table if exists person cascade;
-- set a constraint of age has to be greater than 18
create table if not exists person (id serial primary key, name varchar(50), age integer check(age >= 18));

insert into person values(default, 'carl', 80);
-- we can't add russell because he is too young
insert into person values(default, 'russell', 10);

select * from person;