create table students (name varchar(50));
insert into students values('bob');
insert into students values('anna');
insert into students values('ellie');
insert into students values('chris');
insert into students values('tony');
insert into students values('tim');
insert into students values('fred');

select concat('my name is ' ,name, '. Nice to meet you!') from students;