-- get a clean fresh start
drop table if exists pet cascade; -- we use cascade if there are other tables/columns that depend on this table
drop table if exists person cascade;

create table if not exists person (id serial primary key, name varchar(50)); -- person table
create table if not exists pet(id serial primary key, name varchar(50), owner_id integer); -- pet table that "references" the person table

insert into person values (default, 'Shaggy'); -- id 1
insert into person values (default, 'John'); -- id 2
insert into person values (default, 'Steve'); -- id 3
insert into person values (default, 'Rory'); -- id 3
insert into person values (default, 'Bob'); -- id 3
insert into person values (default, 'Tony'); -- id 3

insert into pet values(default, 'Scooby Doo', 1); -- "Referencing" shaggy's record
insert into pet values(default, 'Scrappy Doo', 1);
insert into pet values(default, 'Garfield', 2);
insert into pet values (default, 'Odie', 2);
insert into pet values(default, 'Fluffy', null); -- null indicates that we don't have an owner

select * from person;
select * from pet;

-- combine the results of these tables using join:
create view person_pet as 
select person.name as person_name, pet.name as pet_name 
from person join pet 
on pet.owner_id = person.id 
order by person.name;

-- inner join, which only takes records that have corresponding values in both tables
select person.name as person_name, pet.name as pet_name 
from person join pet 
on pet.owner_id = person.id 
order by person.name;

-- left outer join, takes all the records from the left table and leave and won't include right values that don't have a match
select person.name as person_name, pet.name as pet_name 
from person left outer join pet 
on pet.owner_id = person.id 
order by person.name;

-- right outer join, takes all records from the right table and won't include left values that don't have a match
-- now we could have null values in the left side
select person.name as person_name, pet.name as pet_name 
from person right outer join pet 
on pet.owner_id = person.id 
order by person.name;

-- full outer join, takes all records from both tables and leaves any null values where there isn't a corresponding match
select person.name as person_name, pet.name as pet_name 
from person full outer join pet 
on pet.owner_id = person.id 
order by person.name;


-- Try the same thing without a join (inner join)
select pet.name, person.name from pet, person where pet.owner_id = person.id;







drop table if exists department, employee, employee_department ;

-- many to many:
create table department(id serial primary key, name varchar(50));
create table employee(id serial primary key, name varchar(50));
create table employee_department(department_id integer references department, employee_id integer references employee);

-- insert some records 
insert into department values (default, 'training');
insert into department values (default, 'sales');
insert into department values (default, 'HR');

insert into employee values (default, 'bob');
insert into employee values (default, 'tim');
insert into employee values (default, 'fred');
insert into employee values (default, 'gale');

-- insert relationships:
insert into employee_department values(1, 1);
insert into employee_department values(1, 2);
insert into employee_department values(2, 3);
insert into employee_department values(2, 4);
insert into employee_department values(3, 1);
insert into employee_department values(3, 1);

select * from department ;
select * from employee;
select * from employee_department ; -- 3rd table

-- join to see some good data
--create view employee_with_department as select * from employee full outer join employee_department on employee.id = employee_department.employee_id;
--
--create view department_with_employee as select * from department full outer join employee_department on department.id = employee_department.department_id;

-- non join way:
select employee.name, department.name from department, employee, employee_department where employee_department.department_id = department.id and employee_department.employee_id = employee.id;
-- join:
select employee.name, department.name from department full outer join employee_department on department.id = employee_department.department_id full outer join employee on employee.id = employee_department.employee_id;

