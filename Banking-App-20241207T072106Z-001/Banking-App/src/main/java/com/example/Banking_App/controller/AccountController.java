package com.example.Banking_App.controller;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //add account rest api
    //admin api
    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<AccountDto> addAccount(@RequestBody @Valid AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account rest api
    //public api
    @GetMapping("/id/{id}")
    @Operation(summary = "checking", description = "sad;lfkjalkdsjf")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.FOUND);
    }

    //deposit rest api
    //user api
    @PutMapping("/{id}/deposit")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<AccountDto> deposit(@PathVariable long id,@RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.deposit(id, request.get("amount"));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    //withdraw rest api
    //user api
    @PatchMapping("/{id}/withdraw")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.withdraw(id, request.get("amount"));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    //get all accounts
    //public api
    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> list = accountService.getAllAccount();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //delete account rest api
    //user api
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> delete(@PathVariable long id){
        accountService.deleteAccount(id);
        return  new ResponseEntity<>("Account is Deleted Successfully!...", HttpStatus.OK);
    }

    //transfer amount between two accounts
    //user api
    @PostMapping("/{fromAccountId}/transfer/{toAccountId}")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> transfer(@PathVariable long fromAccountId,
                                           @PathVariable long toAccountId,
                                           @RequestBody Map<String, Double> request){
        accountService.transfer(fromAccountId, toAccountId, request.get("amount"));
        return new ResponseEntity<>("Amount Transfered Successfully", HttpStatus.OK);
    }

    //user api
    //check bank balance
    @GetMapping("/{id}")
    public ResponseEntity<String> checkBalance(@PathVariable long id){
        return new ResponseEntity<>("Account Balance is: "+accountService.checkBalance(id), HttpStatus.OK);
    }
}
