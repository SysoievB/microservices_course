create table cards
(
    amount_used      integer not null,
    available_amount integer not null,
    total_limit      integer not null,
    card_id          bigint  not null auto_increment,
    created_at       datetime(6),
    updated_at       datetime(6),
    card_number      varchar(255),
    card_type        varchar(255),
    created_by       varchar(255),
    mobile_number    varchar(255),
    updated_by       varchar(255),
    primary key (card_id)
);
