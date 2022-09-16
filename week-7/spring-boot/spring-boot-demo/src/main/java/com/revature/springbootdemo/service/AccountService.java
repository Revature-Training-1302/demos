package com.revature.springbootdemo.service;

import com.revature.springbootdemo.entity.Account;
import com.revature.springbootdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public void insert(Account account) {
        accountRepository.save(account);
    }

    // set this method to read only because we're not changing the database:
    // Isolation level to only read commited data
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Account getById(Long id) {
        return accountRepository.findById(id).get();
    }

//    @Transactional
    @Transactional
    public void transfer(Long donor, Long recip, int amount) {
        deductFunds(donor, amount);
        // because we are using @Transactional, we roll back the changes if this operation fails:
        addFunds(recip, amount);
        // TODO test with invalid id's
    }

    // Make sure that we have a transaction before going into this method
    @Transactional(propagation = Propagation.MANDATORY)
    // Given an account id and an amount, deduct the amount from the account's balance and then persist it:
    public void deductFunds(Long id, int amount) {
        Account account = getById(id);
        account.setAmount(account.getAmount() - amount);
        accountRepository.save(account);
    }

    // Make sure that we have a transaction:
    // Given an account id and an amount, add the amount from the account's balance and then persist it:
    @Transactional(propagation = Propagation.MANDATORY)
    public void addFunds(Long id, int amount) {
        Account account = getById(id);
        account.setAmount(account.getAmount() + amount);
        accountRepository.save(account);
    }


}

/*
Dirty Read
Account 1 has 15 dollars
Account 2 has 20 dollars

Start transaction 1 (transfer 30 dollars from account 1 to 2)
Add 30 dollars to account 2
Account 2 now has 50 dollars

Before we commit, a different transaction reads account 2's balance as 50 dollars

Back in transaction 1, account 1 tries to deduce 30 dollars from its balance
This fails because account 1 only has 15 dollars

So, the entire transaction is rolled back.

Account 2 goes back to having 20 dollars.

The data that was read in transaction 2 is incorrect because it was rolled back.



 */
