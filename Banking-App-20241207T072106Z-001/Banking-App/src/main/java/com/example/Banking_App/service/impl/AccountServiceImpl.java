package com.example.Banking_App.service.impl;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.entity.Account;
import com.example.Banking_App.exception.AccountException;
import com.example.Banking_App.mapper.AccountManager;
import com.example.Banking_App.repository.AccountRepository;
import com.example.Banking_App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountManager.mapToAccount(accountDto);
        return AccountManager.mapToAccountDto(accountRepository.save(account));
    }

    @Override
    public AccountDto getAccountById(long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountException("Account does not exist"));
        return AccountManager.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountManager.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountException("Accoundt does not Exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountManager.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)->AccountManager.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }

    @Override
    public void transfer(long fromAccountId, long toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(()->new AccountException("Account does not exist"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(()->new AccountException("Account does not exist"));

        if(fromAccount.getBalance() < amount){
            throw new RuntimeException("Insufficient Balance");
        }

        double total = fromAccount.getBalance() - amount;
        fromAccount.setBalance(total);
        accountRepository.save(fromAccount);

        double total1 = toAccount.getBalance() + amount;
        toAccount.setBalance(total1);
        accountRepository.save(toAccount);
    }

    @Override
    public double checkBalance(long id) {
        Account account = accountRepository.findById(id).get();
        return account.getBalance();
    }
}
