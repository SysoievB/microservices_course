package com.accounts.service;

import com.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
