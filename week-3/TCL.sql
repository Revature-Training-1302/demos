drop table if exists bank_account ;
create table if not exists bank_account (id serial primary key, amount integer);

insert into bank_account values (default, 1000);
insert into bank_account values (default, 2000);

select * from bank_account;


-- if we want to perform an action that could result inconsistences, we can use transactions
-- for example, transfer money from account 1 to account 2:
-- How can we take $100 from account 2 to account 1:

begin; -- begin transaction (group of commands)
update bank_account set amount = amount - 100 where id = 2;
update bank_account set amount = amount + 100 where id = 1;
commit; -- commit/persist these changes

select * from bank_account ;

begin; -- atomicty, where everything happens or nothing happens:
update bank_account set amount = amount + 3000 where id = 1;
update bank_account set amount = amount - 3000 where id = 2; -- trying to take 3000 dollars out of an account that only has 1900
-- at this point, we know that this isn't what we want, so we can rollback the entire operation
commit;

begin; -- we need this command to begin the transaction
update bank_account set amount = 1000000 where id = 1;
rollback; -- this will undo everything we did since the begin statement
commit;


select * from bank_account;

-- TODO, figure out save point:
begin;
insert into bank_account values (default, 3000);
savepoint first_save;
insert into bank_account values (default, 4000);
rollback to savepoint first_save;
commit;
select * from bank_account ;