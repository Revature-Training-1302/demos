-- insert data into a table:
insert into pet (id, name, species, food) values (default, 'Ashes', 'cat', 'tuna');
insert into pet (id, name, species, food) values (default, 'Shadow', 'cat', 'water');

-- update data:
update pet set name = 'Garfield' where name = 'Ashes';

-- delete data:
delete from pet where name = 'Shadow';