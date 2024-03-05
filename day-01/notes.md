# Notes on day 1

## Categories of SQL commands:

- DDL - data definition language
    - create, alter, drop
    - creating/modifying/deleting the db objects such as table, view, index, user, sequence...
- DML - data manipulation language
    - manipulate data in a table
    - insert, update, delete
- Query - read data from tables and views
    - select
- TCL - transaction control language
    - provides an option to execute multiple DML statements as a single atomic operation
    - commit, rollback
    - begin transaction (in case of MSSQL server)


```sql
create table customers(
    id integer primary key auto_increment,
    name varchar(20) not null,
    gender varchar(6) check (gender in ('Male', 'Female')) default 'Male',
    city varchar(50) default 'Bangalore',
    email varchar(255) unique,
    phone varchar(15) not null unique
);

```

more formal with constraint names...


```sql
create table customers(
    id integer,
    name varchar(20) not null,
    gender varchar(6) default 'Male',
    city varchar(50) default 'Bangalore',
    email varchar(255),
    phone varchar(15) not null,
    constraint pk_customers primary key (id),
    constraint chk_customers_gender check (gender in ('Male', 'Female')),
    constraint unq_customers_email unique (email),
    constraint unq_customers_phone unique (phone)
);

```

alter table to add a new column

```sql
alter table customers
add country varchar(50) default 'India';
```

add/modify/delete customers

```sql
insert into customers values (null, 'Vinod', 'Male', 'Bangalore', 'vinod@vinod.co', '9731424784', 'India');
insert into customers (name, email, phone) values ('Ramesh Kumar', 'rameshkumar@xmpl.com', '9998887771');

insert into customers (name, phone, gender) values
('Ramya', '9879879876', 'Female'),
('Suma', '9870009876', 'Female'),
('Rajesh', '9870022276', default);

update customers
set city='Vasco', email='suma@xmpl.com'
where id=4;

update customers
set city='Chennai'
where name in ('Ramesh Kumar', 'Rajesh');

```