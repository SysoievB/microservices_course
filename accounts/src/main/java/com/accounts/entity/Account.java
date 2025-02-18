package com.accounts.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long accountNumber;
    String accountType;
    String branchAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Customer customer;

    public Account(Long accountNumber, String accountType, String branchAddress) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
    }
}
