create table CUSTOMERS
(
    id serial PRIMARY KEY,
    name varchar(30) NOT NULL,
    surname varchar(60) NOT NULL,
    age int NOT NULL,
    phone_number varchar(20)
);
create table ORDERS
(
    id serial PRIMARY KEY,
    date timestamp DEFAULT now(),
    customer_id int NOT NULL,
    product_name varchar(150) NOT NULL,
    amount int NOT NULL,
    CHECK ( amount > 0),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);
create index cust_id on ORDERS (customer_id);