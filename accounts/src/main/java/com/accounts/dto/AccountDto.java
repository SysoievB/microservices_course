package com.accounts.dto;

public record AccountDto(Long accountNumber,
                         String accountType,
                         String branchAddress) {
}
