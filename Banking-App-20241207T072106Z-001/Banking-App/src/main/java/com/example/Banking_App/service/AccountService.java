package com.example.Banking_App.service;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(long id);
    AccountDto deposit(long id, double amount);
    AccountDto withdraw(long id, double amount);
    List<AccountDto> getAllAccount();
    void deleteAccount(long id);
    void transfer(long fromAccountId, long toAccountId, double amount);
    double checkBalance(long id);
}
