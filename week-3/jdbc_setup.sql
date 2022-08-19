
create table pet (id serial primary key, name varchar(50), species varchar(50), food varchar(50));

-- our new addition to the project will be adding a person table
create table person (id serial primary key, name varchar(50), password varchar(50));

insert into person values(default, 'rory', 'password');


select * from pet;
select * from person;

-- our goal for this demo is to create a relationship between pets and people where a person can adopt many pets but a pet can only have one owner
alter table pet add column pet_id integer;
-- at first, our owner_id column in the pet table will have a bunch null values (indicating that they are not adopted yet)

-- we can achieve the process of adoption by updating a record:
update pet set owner_id = 1 where id = 3; -- owner with id 1 is adopting pet with id 3
update pet set owner_id = 1 where id = 6; -- owner with id 1 adopting pet with id 6

-- how can we check which pets belong to a specific person?
select * from pet where owner_id = 1; -- select all pets with owner id 1
select * from pet where owner_id = 2; -- select all pets with owner id 2 (empty is no pets adopted)

select * from pet;
