-- first, we can create a new user:
create user intern with password 'intern123';

create table if not exists financial_information(id serial primary key, amount integer, account_password varchar(50));
insert into financial_information values (default, 10000, 'secret');

-- to be able to perform queries/commands as the user, we need to log first
-- Before we do that let's set up some restrictions


-- specify the commands, the table, and the user
revoke insert, update, delete on table financial_information from intern;
-- the intern should only be able to view information, not change it/manipulate it
grant select on financial_information to intern;


-- TODO: Look into revoke access to database
revoke connect on database postgres from intern; -- revoke the user from even connecting:

-- Select should be allowed:
select * from financial_information;

-- Permission Denied for these commands:
delete from financial_information ;
insert into financial_information values (default, 1000000000, 'secret1');
update financial_information set amount = -20;