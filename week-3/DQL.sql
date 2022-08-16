create table if not exists person (id serial primary key, name varchar(50), occupation varchar(50), salary integer);

insert into person values (default, 'rory', 'astronaut', 500);
insert into person values (default, 'harry', 'wizard', 200);
insert into person values (default, 'ron', 'wizard', 100);
insert into person values (default, 'luke', 'jedi', 0);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'shrek', 'vigilante', 300);
insert into person values (default, 'harry', 'musician', 2000);
insert into person values (default, 'anna', 'musician', 2000);

-- I want all the information
-- * means we want every single column/attribute
-- because we don't have a where clause, we get every record
select * from person;

-- specify columns
select name, occupation from person;

-- specify rows:
select * from person where occupation = 'wizard';
select * from person where salary > 300;

-- a common query is to view a record by the id:
-- if a column is a primary key, we are guaranteed to only get one record (none) (because it is unique)
select * from person where id = 100;

select * from person where name = 'harry';

-- Like keyword
-- we can use the like keyword in the exact same way as the =
select * from person where name like 'ron';

-- added functionality:
-- the % is sort of a "catch-all" symbol, needs at least one character
-- in this case, we just care that the string starts with r and ends with whatever
select * from person where name like 'r%';

-- how to get names that end with y
select * from person where name like '%y';

-- to find letters in the middle
select * from person where name like '%a%';

select * from person where salary/1000 = 2;



-- Dates
alter table person add column bday date;

-- update existing rows to include data
update person set bday = '1970-01-01';
update person set bday = '1980-07-31' where name = 'harry';
update person set bday = '1980-04-01' where name = 'ron';
update person set bday = '02-09-2010' where name = 'shrek';

-- select people born before 1980, jan 1st
select * from person where bday < '1980-01-01';

-- select people born afer 1980, jan 1st
select * from person where bday >'1980-01-01';

-- timestamp stores data and time
create table if not exists work_times (start_time timestamp);

insert into work_times values ('2016-06-22 19:10:25-07');

select * from work_times;

