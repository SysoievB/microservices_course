package com.accounts.service.impl;

import com.accounts.dto.AccountDto;
import com.accounts.dto.CardsDto;
import com.accounts.dto.CustomerDetailsDto;
import com.accounts.dto.LoansDto;
import com.accounts.exception.ResourceNotFoundException;
import com.accounts.repository.AccountJpaRepository;
import com.accounts.repository.CustomerJpaRepository;
import com.accounts.service.ICustomersService;
import com.accounts.service.client.CardsFeignClient;
import com.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.accounts.mapper.AccountMapper.mapToAccountsDto;
import static com.accounts.mapper.CustomerMapper.mapToCustomerDetailsDto;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountJpaRepository accountsRepository;
    private CustomerJpaRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        val customer = customerRepository.findByPhoneNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        val accounts = accountsRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getId().toString()));

        CustomerDetailsDto customerDetailsDto = mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(mapToAccountsDto(accounts, new AccountDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}