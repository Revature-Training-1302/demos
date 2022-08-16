-- drop tables at the start:
drop table if exists pets;
drop table if exists food;

-- imagine a pet could like many foods
create table pets (id integer primary key, name varchar(50));
create table food (id serial primary key, name varchar(50));
alter table food alter column name set default 'pancakes';

-- when we insert data into the table, we can specify our id
insert into pets (id, name) values (1, 'Ashes');
-- We can't input a null value to a column that is a primary key
-- insert into pets (id, name) values (null, 'Ashes');
-- we can't add a repeat value to our primary key column:
-- insert into pets (id, name) values (1, 'Ashes');
insert into pets (id, name) values (2, 'Ashes');

-- Because we used the serial keyword with the food table, we can use the default keyword to count up for us:
insert into food(id, name) values (default, 'meow mix'); -- id 1
insert into food(id, name) values (default, 'kibble'); -- id 2
insert into food(id, name) values (default, 'bird seed'); -- id 3
insert into food(id, name) values (default, default); -- id 4 -- if we say food is default, it will show up as pancakes
insert into food(id) values (default); -- if we don't specify the food at all, it will be pancakes


