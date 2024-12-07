package com.example.Banking_App.mapper;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.entity.Account;

public class AccountManager {

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getAccountId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getAccountId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }

    public static AccountDto updateAccount(Account account, AccountDto accountDto){
            accountDto.setAccountId(account.getAccountId());
            accountDto.setAccountHolderName(account.getAccountHolderName());
            accountDto.setBalance(account.getBalance());
            return accountDto;
    }
}

