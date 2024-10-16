package com.accounts.service.impl;

import com.accounts.dto.AccountDto;
import com.accounts.dto.CustomerDto;
import com.accounts.entity.Account;
import com.accounts.entity.Customer;
import com.accounts.exception.CustomerAlreadyExistsException;
import com.accounts.exception.ResourceNotFoundException;
import com.accounts.repository.AccountJpaRepository;
import com.accounts.repository.CustomerJpaRepository;
import com.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.accounts.constants.AccountConstants.ADDRESS;
import static com.accounts.constants.AccountConstants.SAVINGS;
import static com.accounts.mapper.AccountMapper.mapToAccounts;
import static com.accounts.mapper.AccountMapper.mapToAccountsDto;
import static com.accounts.mapper.CustomerMapper.mapToCustomer;
import static com.accounts.mapper.CustomerMapper.mapToCustomerDto;

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
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerJpaRepository.findByPhoneNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountJpaRepository.findByCustomerId(customer.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "id", customer.getId().toString())
        );
        CustomerDto customerDto = mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(mapToAccountsDto(account, new AccountDto()));
        return customerDto;
    }


    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setId(customer.getId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(SAVINGS.getDescription());
        newAccount.setBranchAddress(ADDRESS.getDescription());
        return newAccount;
    }

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccountDto();
        if (accountDto != null) {
            Account account = accountJpaRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountDto.getAccountNumber().toString())
            );
            mapToAccounts(accountDto, account);
            account = accountJpaRepository.save(account);

            Long customerId = account.getId();
            Customer customer = customerJpaRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            mapToCustomer(customerDto, customer);
            customerJpaRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerJpaRepository.findByPhoneNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountJpaRepository.deleteByCustomerId(customer.getId());
        customerJpaRepository.deleteById(customer.getId());
        return true;
    }
}
