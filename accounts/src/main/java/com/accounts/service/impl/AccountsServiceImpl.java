package com.accounts.service.impl;

import com.accounts.dto.CustomerDto;
import com.accounts.entity.Account;
import com.accounts.entity.Customer;
import com.accounts.exception.CustomerAlreadyExistsException;
import com.accounts.repository.AccountJpaRepository;
import com.accounts.repository.CustomerJpaRepository;
import com.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.accounts.constants.AccountConstants.ADDRESS;
import static com.accounts.constants.AccountConstants.SAVINGS;
import static com.accounts.mapper.CustomerMapper.mapToCustomer;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountService {
    private final AccountJpaRepository accountJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = mapToCustomer(customerDto, new Customer());
        customerJpaRepository.findByPhoneNumber(customerDto.getPhoneNumber())
                .ifPresent(c -> {
                    throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                                    + customerDto.getPhoneNumber());
                });
        Customer savedCustomer = customerJpaRepository.save(customer);
        accountJpaRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        //todo add one to one
        //newAccount.setId(customer.getId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(SAVINGS.getDescription());
        newAccount.setBranchAddress(ADDRESS.getDescription());
        return newAccount;
    }
}
