-- This is how we write comments in SQL
-- Data Definition Language


-- define the schema, columns
create table if not exists pet (id integer, name varchar(50), species varchar(50), food varchar(50));

-- specify that we are dropping a table, we specify the name of the table
drop table if exists pet;

-- say we spelled something wrong:
create table pet(id integer, name varchar(50), species varchar(50), foood varchar(50));
-- we can alter the table to fix the spelling mistake:
alter table pet rename column foood to food;
-- add columns
alter table pet add column dumb_column integer;
-- drop columns
alter table pet drop column dumb_column ;


-- truncate, we need DML to see this in action
create table fruits (name varchar(50));
insert into fruits values ('apple');
insert into fruits values ('banana');
insert into fruits values ('orange');
insert into fruits values ('lemon');
insert into fruits values ('kiwi');
select * from fruits;
-- truncate wipes out a table completely
truncate fruits;
drop table fruits;



drop table pet;
create table pet (id serial primary key, name varchar(50), species varchar(50), food varchar(50));