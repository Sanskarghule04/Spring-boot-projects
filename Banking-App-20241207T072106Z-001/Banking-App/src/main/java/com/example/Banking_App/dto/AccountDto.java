package com.example.Banking_App.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private long accountId;

    @NotEmpty
    @Size(min = 4, message = "Name must have 4 letters")
    private String accountHolderName;

    private double balance;
}
