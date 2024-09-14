package com.accounts.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AccountConstants {
    SAVINGS("Savings"),
    ADDRESS("123 Main Street, New York"),
    STATUS_201("201"),
    MESSAGE_201("Account created successfully"),
    STATUS_200("200"),
    MESSAGE_200("Request processed successfully"),
    STATUS_417("417"),
    MESSAGE_417_UPDATE("Update operation failed. Please try again or contact Dev team"),
    MESSAGE_417_DELETE("Delete operation failed. Please try again or contact Dev team");

    private final String description;
}
