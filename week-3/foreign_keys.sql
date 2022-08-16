-- we add the cascade keyword so that if we drop a table which another depends on, then we will delete those records that are being referenced
drop table if exists pet cascade;
drop table if exists person cascade;
drop table if exists food cascade;
drop table if exists pet_favorite_food cascade;
drop table if exists license cascade;
drop table if exists driver cascade;

-- first we create a person table to represent the owners
create table if not exists person(id serial primary key, name varchar(50));

-- then we have the pet table reference the person table through a foreign key relation:
-- in this case, we are saying that the owner_id field references the primary key of the person table
create table if not exists pet(id serial primary key, name varchar(50), owner_id integer references person(id));

-- Pet to owner relationship is 1 to many relationship
-- One owner could have multiple pets
-- But one pet can't have multiple owners

insert into person values (default, 'rory');
insert into person values (default, 'shaggy');

insert into pet values (default, 'ashes', 1); -- we use rory's id
insert into pet values (default, 'scooby doo', 2); -- we use shaggy's id
insert into pet values (default ,'scrappy doo', 2); -- use shaggy's id again
insert into pet values (default, 'shadow', 1); -- use rory's id again


-- one benefit of foreign keys is referential integrity
-- In this example, we don't want a pet to reference an owner that doesn't exists 
-- Example: an owner with id 3
-- insert into pet values (default, 'garfield', 3); -- Error, foreign key not present in the person table





-- Why don't we store everything in one table
-- scenario let's say rory has 1000 pets:
-- for every pet, we would be repeating the information for the owners 
-- rory, ashes
-- rory, shadow 
-- rory, ..


-- many to many
create table if not exists food (id serial primary key, name varchar(50));
insert into food values(default, 'scooby snacks');
insert into food values(default, 'tuna');
insert into food values(default, 'cat food');
insert into food values(default, 'sandwiches');


select * from pet;
select * from person;
select * from food;

-- set up a many to many between the pet table and the food table
-- this table isn't an entity, it represents a relationship between the 2 entities: pet and food
create table if not exists pet_favorite_food(pet_id integer references pet, food_id integer references food);

insert into pet_favorite_food values (1, 2);
insert into pet_favorite_food values (1, 3);
insert into pet_favorite_food values (2, 1);
insert into pet_favorite_food values (2, 4);
insert into pet_favorite_food values (3, 1);
insert into pet_favorite_food values (3, 4);


select * from pet_favorite_food ;

-- TODO, use joins to get some better output

-- 1 to 1 relationship 
-- pet references food 
-- food references pet
-- pet: (1, 'Ashes', owner=1, food=3)
-- food: (3, 'tuna', pet = 1)

-- one driver will have one license and one license will have one driver
create table if not exists driver(id serial primary key, name varchar(50));
-- we use "deferrable intially deferred" to say that we won't have the id when we first make it
create table if not exists license(id serial primary key, driver_id integer references driver deferrable initially deferred);
alter table driver add column  licene_id integer references license deferrable initially deferred;

-- when we insert into the driver table, we need a license id
insert into driver values(default, 'spongebob');
-- so we try to insert into license table, but now we need a driver id
insert into license values(default, 1);

-- We need some work-around for this paradoxical relationship

select * from driver;
select * from license;



