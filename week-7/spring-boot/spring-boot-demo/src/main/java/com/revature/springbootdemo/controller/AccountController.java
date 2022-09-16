package com.revature.springbootdemo.controller;

import com.revature.springbootdemo.dto.AccountTransfer;
import com.revature.springbootdemo.entity.Account;
import com.revature.springbootdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping
    public Account add(@RequestBody Account account) {
        accountService.insert(account);
        return account;
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable("id") Long id) {
        return accountService.getById(id);
    }

    // Use our DTO to package everything together that we need for a transfer:
    @PatchMapping
    public void transfer(@RequestBody AccountTransfer transfer) {
        accountService.transfer(transfer.getDonor(), transfer.getRecip(), transfer.getAmount());
    }





}
