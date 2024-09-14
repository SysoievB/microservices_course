package com.accounts.controller;

import com.accounts.dto.AccountDto;
import com.accounts.dto.CustomerDto;
import com.accounts.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.accounts.constants.AccountConstants.MESSAGE_201;
import static com.accounts.constants.AccountConstants.STATUS_201;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(CREATED)
                .body(new ResponseDto(STATUS_201.getDescription(), MESSAGE_201.getDescription()));
    }
}
