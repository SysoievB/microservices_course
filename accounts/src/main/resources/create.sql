create table accounts
(
    id             bigint not null auto_increment,
    created_at   date,
    updated_at   date,
    created_by   varchar(255),
    updated_by   varchar(255),
    account_number bigint,
    account_type   varchar(255),
    branch_address varchar(255),
    primary key (id)
);
create table customers
(
    id           bigint not null auto_increment,
    created_at   date,
    updated_at   date,
    created_by   varchar(255),
    email        varchar(255),
    name         varchar(255),
    phone_number varchar(255),
    updated_by   varchar(255),
    primary key (id)
);