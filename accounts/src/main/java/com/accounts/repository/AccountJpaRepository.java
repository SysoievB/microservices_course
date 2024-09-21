package com.accounts.repository;

import com.accounts.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    @Query("""
            SELECT a FROM Account a WHERE a.customer.id = :customerId
            """)
    Optional<Account> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
