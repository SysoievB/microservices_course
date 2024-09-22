create table loans
(
    amount_paid        integer not null,
    outstanding_amount integer not null,
    total_loan         integer not null,
    created_at         datetime(6),
    loan_id            bigint  not null auto_increment,
    updated_at         datetime(6),
    created_by         varchar(255),
    loan_number        varchar(255),
    loan_type          varchar(255),
    mobile_number      varchar(255),
    updated_by         varchar(255),
    primary key (loan_id)
);
