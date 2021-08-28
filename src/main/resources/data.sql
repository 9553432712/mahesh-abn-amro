create table account
(id bigint not null, account_number varchar(255), balance decimal(19,2), primary key (id)
);

create table transaction (id bigint not null, amount decimal(19,2), creation_date date, from_account_number varchar(255), status integer, to_account_number varchar(255), primary key (id))