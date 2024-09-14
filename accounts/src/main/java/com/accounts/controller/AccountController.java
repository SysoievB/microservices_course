package com.accounts.controller;

import com.accounts.dto.CustomerDto;
import com.accounts.dto.ResponseDto;
import com.accounts.service.IAccountService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.accounts.constants.AccountConstants.MESSAGE_201;
import static com.accounts.constants.AccountConstants.STATUS_201;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService service;

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody CustomerDto customerDto) {
        service.createAccount(customerDto);
        return ResponseEntity.status(CREATED)
                .body(new ResponseDto(STATUS_201.getDescription(), MESSAGE_201.getDescription()));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
            String mobileNumber
    ) {
        CustomerDto customerDto = service.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
}
