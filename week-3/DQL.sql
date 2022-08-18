-- drop the table to begin with:
drop table if exists person;
-- start from scratch
create table if not exists person (id serial primary key, name varchar(50), occupation varchar(50), salary integer);

insert into person values (default, 'rory', 'astronaut', 500);
insert into person values (default, 'harry', 'wizard', 200);
insert into person values (default, 'ron', 'wizard', 100);
insert into person values (default, 'luke', 'jedi', 0);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'shrek', 'vigilante', 300);
insert into person values (default, 'harry', 'musician', 2000);
insert into person values (default, 'anna', 'musician', 2000);
insert into person values (default, 'mike', 'musician', 2000);
insert into person values (default, 'ben', 'musician', 2000);
insert into person values (default, 'dan', 'musician', 2000);
insert into person values (default, 'han', 'musician', 2000);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'gandalf', 'wizard', 1000);
insert into person values (default, 'gandalf', 'wizard', 1000);

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





-- order by
select name, salary from person order by salary desc, name asc;

-- limit
select name, salary from person order by salary asc limit 5;


-- Group By, group results by a specific column (in this case we want every occupation with a salary greater than 1000):
-- Having, like "where" clause but it acts on an entire group:
select occupation, avg(salary) from person group by occupation;
select occupation, avg(salary) from person group by occupation having avg(salary) > 500;
-- aggregate functions because they operate on groups
select occupation, max(salary) from person group by occupation;
select occupation, min(salary) from person group by occupation;
select occupation, sum(salary) from person group by occupation;
select occupation, count(salary) from person group by occupation;

-- scalar functions, use alias for column names
select upper(name) as upper_name, lower(name) as lower_name, length(name) as letter_count from person order by length(name);

-- Set Operations, these are going to act on 2 separate results from 2 different queries:
-- intersect operation
(select * from person where occupation = 'wizard')
intersect -- intersect operation takes records that are in both results
(select * from person where salary > 500);

-- same as: select * from person where occupation = 'wizard' and salary > 500;

-- union operation 
(select * from person where occupation = 'wizard')
union -- union operation takes records that are in either results
(select * from person where salary > 500);

-- union all operation
(select * from person where occupation = 'wizard')
union all -- union all acts like union but also shows duplicate values (records that are returned from both queries)
(select * from person where salary > 500);

-- except operation 
(select * from person where occupation = 'wizard')
except -- except takes everything in the first query except those records from the second query
(select * from person where salary > 500);

-- sub-queries - using a query within another query
-- select all records from person where the salary is greater than the average salary
select * from person where salary >
(select avg(salary) from person); -- sub-query because it exists within the outer query

-- view - store the results of a query into a reusable view (kind of like a temporary table):
create view rich_wizards as
select * from person where occupation = 'wizard' and salary >= 1000;

select * from rich_wizards;













