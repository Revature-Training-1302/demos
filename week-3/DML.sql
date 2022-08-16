-- insert data into a table:
insert into pet (id, name, species, food) values (default, 'Ashes', 'cat', 'tuna');
insert into pet (id, name, species, food) values (default, 'Shadow', 'cat', 'water');
-- if we don't specify the fields, we have to put them in the right order
insert into pet values (default, 'cat', 'Ashes', 'water');
-- if we do specify the fields, we just have to match the field order that we specify in the insert statement
insert into pet (name, species, food, id) values ('Ashes', 'cat', 'tuna', default);

-- update data:
update pet set name = 'Garfield' where name = 'Ashes';
-- if we don't have a where clause, every record will be updated:
update pet set name = 'new name';

-- delete data:
delete from pet where name = 'cat';

-- Be careful with delete statements, with no clause:
delete from pet;